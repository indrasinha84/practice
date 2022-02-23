package algopractice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExampleReentrantLock {

	public static void main(String[] args) throws InterruptedException {
		DeadLockExampleReentrantLock dle = new DeadLockExampleReentrantLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					dle.methodA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					dle.methodB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
//		t1.join();
		t2.start();
	}

	class LockObject {

	}

	ReentrantLock lockA = new ReentrantLock();
	ReentrantLock lockB = new ReentrantLock();

	public void methodA() throws InterruptedException {
		while (1 == 1) {
			if (!lockA.isLocked() && !lockB.isLocked()) {
				Thread.sleep(10);
				lockA.tryLock();
			}
			if (lockA.isHeldByCurrentThread()) {
				break;
			}
		}
		while (1 == 1) {
			if (!lockB.isLocked() && lockA.isHeldByCurrentThread()) {
				lockB.tryLock();
			}
			if (lockB.isHeldByCurrentThread()) {
				break;
			}
		}
		System.out.println("methodA about to sleep");
		Thread.sleep(1000);
		System.out.println("methodA woke up");

		if (lockB.isHeldByCurrentThread())
			lockB.unlock();
		if (lockA.isHeldByCurrentThread())
			lockA.unlock();

	}

	public void methodB() throws InterruptedException {
		while (1 == 1) {
			if (!lockB.isLocked() && !lockA.isLocked()) {
				Thread.sleep(5);
				lockB.tryLock();
			}
			if (lockB.isHeldByCurrentThread()) {
				break;
			}
		}
		while (1 == 1) {
			if (!lockA.isLocked() && lockB.isHeldByCurrentThread()) {
				lockA.tryLock();
			}
			if (lockA.isHeldByCurrentThread()) {
				break;
			}
		}
		System.out.println("methodB about to sleep");
		Thread.sleep(1000);
		System.out.println("methodB woke up");
		if (lockA.isHeldByCurrentThread())
			lockA.unlock();
		if (lockB.isHeldByCurrentThread())
			lockB.unlock();

	}

}
