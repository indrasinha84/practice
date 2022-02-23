package multithread.sequence.number;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceRunnerUsingWaitNotify implements Runnable {
	int limit;
	AtomicInteger position;
	boolean even;

	public SequenceRunnerUsingWaitNotify(boolean even, int limit, AtomicInteger position) {
		this.even = even;
		this.limit = limit;
		this.position = position;
	}

	@Override
	public void run() {
		while (position.get() <= limit) {
			if ((position.get() % 2 == 0 && even) || (position.get() % 2 == 1 && !even))
				System.out.println(Thread.currentThread() + "-" + position.getAndAdd(1));
			synchronized (position) {
				
				position.notifyAll();

			try {
				position.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
	}
	
	public static void main(String[] args) {
		AtomicInteger position = new AtomicInteger(0);
		int limit = 200;

		SequenceRunnerUsingWaitNotify evenRun = new SequenceRunnerUsingWaitNotify(false, limit, position);
		SequenceRunnerUsingWaitNotify oddRun = new SequenceRunnerUsingWaitNotify(true, limit, position);
		new Thread(evenRun, "Thread 1").start();
		new Thread(oddRun, "Thread 2").start();
	}

}
