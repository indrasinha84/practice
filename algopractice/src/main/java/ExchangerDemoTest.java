import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

public class ExchangerDemoTest {

	private static final int BUFFER_SIZE = 1;

	@Test
	public void givenThreads_whenMessageExchanged_thenCorrect() {
		
		 Executors.newFixedThreadPool(1);
		Exchanger<String> exchanger = new Exchanger<>();

		Runnable taskA = () -> {
			try {
				String message = exchanger.exchange("from A");
				assertEquals("from B", message);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(e);
			}
		};

		Runnable taskB = () -> {
			try {
				String message = exchanger.exchange("from B");
				assertEquals("from A", message);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException(e);
			}
		};
		CompletableFuture.allOf(CompletableFuture.runAsync(taskA), CompletableFuture.runAsync(taskB)).join();
	}

	@Test
	public void givenData_whenPassedThrough_thenCorrect() throws InterruptedException {

		Exchanger<Queue<String>> readerExchanger = new Exchanger<>();
		Exchanger<Queue<String>> writerExchanger = new Exchanger<>();

		Runnable reader = () -> {
			Queue<String> readerBuffer = new ConcurrentLinkedQueue<>();
			while (true) {
				readerBuffer.add(UUID.randomUUID().toString());
				if (readerBuffer.size() >= BUFFER_SIZE) {
					try {
						readerBuffer = readerExchanger.exchange(readerBuffer);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Runnable processor = () -> {
			Queue<String> processorBuffer = new ConcurrentLinkedQueue<>();
			Queue<String> writerBuffer = new ConcurrentLinkedQueue<>();
			try {
				processorBuffer = readerExchanger.exchange(processorBuffer);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			while (true) {
				writerBuffer.add(processorBuffer.poll());
				if (processorBuffer.isEmpty()) {
					try {
						processorBuffer = readerExchanger.exchange(processorBuffer);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						writerBuffer = writerExchanger.exchange(writerBuffer);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Runnable writer = () -> {
			Queue<String> writerBuffer = new ConcurrentLinkedQueue<>();
			try {
				writerBuffer = writerExchanger.exchange(writerBuffer);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (true) {
				System.out.println(writerBuffer.poll());
				if (writerBuffer.isEmpty()) {
					try {
						writerBuffer = writerExchanger.exchange(writerBuffer);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		CompletableFuture.allOf(CompletableFuture.runAsync(reader), CompletableFuture.runAsync(processor), CompletableFuture.runAsync(writer)).join();
	}


}
