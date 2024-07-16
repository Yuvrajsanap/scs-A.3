package thread;

class question2 extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(getName() + ": " + i);
			try {
				Thread.sleep(500); // Sleep for 500 milliseconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		question2 thread1 = new question2();
		question2 thread2 = new question2();

		thread1.setName("Thread-1");
		thread2.setName("Thread-2");

		thread1.start();
		thread2.start();
	}
}
