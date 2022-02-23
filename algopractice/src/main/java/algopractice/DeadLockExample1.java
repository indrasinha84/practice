package algopractice;

public class DeadLockExample1 {

	public static void main(String[] args) {
		DeadLockExample1 dle = new DeadLockExample1();
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
		t2.start();
	}

	class LockObject {

	}

	LockObject lockA = new LockObject();
	LockObject lockB = new LockObject();

	public void methodA() throws InterruptedException {
		// ...
		synchronized (lockA) {
			Thread.sleep(1000);
			synchronized (lockB) {
				// ...
			}
		}
	}

	public void methodB() throws InterruptedException {
		// ...
		synchronized (lockB) {
			// ...
			Thread.sleep(1000);
			synchronized (lockA) {
				// ...
			}
		}
	}

}
