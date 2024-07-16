package thread;

public class question4 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "Thread-1");

		System.out.println(t1.getName() + " State: " + t1.getState());

		t1.start();

		System.out.println(t1.getName() + " State: " + t1.getState());

		try {
			Thread.sleep(100);
			System.out.println(t1.getName() + " State: " + t1.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
		try {
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
