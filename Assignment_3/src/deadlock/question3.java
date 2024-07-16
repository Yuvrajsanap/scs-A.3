package deadlock;
//Example of Thread-Safe Class

public class question3 {
	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public synchronized int getCount() {
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		final question3 counter = new question3();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("Thread-safe counter value: " + counter.getCount());
	}
}
