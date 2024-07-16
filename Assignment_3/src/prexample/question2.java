package prexample;

//Program Demonstrating Thread Synchronization
public class question2 {
	private static int counter = 0;

	public static synchronized void increment() {
		counter++;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		System.out.println("Counter value: " + counter);
	}
}
