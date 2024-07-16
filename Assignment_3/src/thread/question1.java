package thread;

class question1 {
	public static void main(String[] args) {

		class MyThread extends Thread {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Thread by extending Thread: " + i);
				}
			}
		}

		class MyRunnable implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Thread by implementing Runnable: " + i);
				}
			}
		}

		MyThread thread1 = new MyThread();
		thread1.start();

		MyRunnable myRunnable = new MyRunnable();
		Thread thread2 = new Thread(myRunnable);
		thread2.start();
	}
}
