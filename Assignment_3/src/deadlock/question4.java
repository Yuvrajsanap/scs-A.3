package deadlock;

//Example of Non-Thread-Safe Class
public class question4 {
	private int count = 0;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		final question4 counter = new question4();
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

		System.out.println("Non-thread-safe counter value: " + counter.getCount());
	}
}
