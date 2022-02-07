package multithread.sequence.number;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SequenceRunner implements Runnable {
	Semaphore ours;
	Semaphore theirs;
	int limit;
	AtomicInteger position;
	boolean even;

	public SequenceRunner(Semaphore ours, Semaphore theirs, boolean even, int limit, AtomicInteger position) {
		this.ours = ours;
		this.theirs = theirs;
		this.even = even;
		this.limit = limit;
		this.position = position;
	}

	@Override
	public void run() {
		while (position.get() <= limit) {
			if ((position.get() % 2 == 0 && even) || (position.get() % 2 == 1 && !even))
				System.out.println(Thread.currentThread() + "-" + position.getAndAdd(1));
			theirs.release();
			try {
				ours.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Semaphore evenSemaphore = new Semaphore(1);
		Semaphore oddSemaphore = new Semaphore(1);
		AtomicInteger position = new AtomicInteger(0);
		int limit = 200;

		SequenceRunner evenRun = new SequenceRunner(oddSemaphore, evenSemaphore, false, limit, position);
		SequenceRunner oddRun = new SequenceRunner(evenSemaphore, oddSemaphore, true, limit, position);
		new Thread(evenRun, "Thread 1").start();
		new Thread(oddRun, "Thread 2").start();
	}

}
