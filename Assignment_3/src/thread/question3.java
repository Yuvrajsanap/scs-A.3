package thread;

class question3 implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		question3 myRunnable = new question3();
		Thread thread1 = new Thread(myRunnable);
		Thread thread2 = new Thread(myRunnable);

		thread1.setName("Runnable-Thread-1");
		thread2.setName("Runnable-Thread-2");

		thread1.start();
		thread2.start();
	}
}
