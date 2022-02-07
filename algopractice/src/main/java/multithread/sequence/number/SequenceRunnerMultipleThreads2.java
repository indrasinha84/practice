package multithread.sequence.number;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceRunnerMultipleThreads2 implements Runnable {
	int limit;
	AtomicInteger position;
	Integer threadNumber;// 0 to totalThreads - 1
	Integer totalThreads;

	public SequenceRunnerMultipleThreads2(Integer totalThreads, Integer threadNumber, int limit,
			AtomicInteger position) {
		this.threadNumber = threadNumber;
		this.totalThreads = totalThreads;
		this.limit = limit;
		this.position = position;
	}

	public SequenceRunnerMultipleThreads2() {
	}

	@Override
	public void run() {
		while (position.get() < limit) {
			if (position.get() % totalThreads == threadNumber)
				System.out.println(Thread.currentThread().getName() + " ----- " + (position.getAndAdd(1) + 1));
			synchronized (position) {
				position.notifyAll();
				try {
					if (position.get() < limit)
						position.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void sequenceRunner(int limit, int totalThreads) {
		AtomicInteger position = new AtomicInteger(0);
		for (int i = 0; i < totalThreads; i++) {
			SequenceRunnerMultipleThreads2 srmt = new SequenceRunnerMultipleThreads2(totalThreads, i, limit, position);
			new Thread(srmt, "Thread " + (i + 1)).start();

		}
	}

	public static void main(String[] args) {
		SequenceRunnerMultipleThreads2 s = new SequenceRunnerMultipleThreads2();
		s.sequenceRunner(100, 3);

	}

}
