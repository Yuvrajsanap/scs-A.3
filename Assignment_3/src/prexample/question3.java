package prexample;

//Program Demonstrating Thread Synchronization
public class question3 {
	private static int sharedValue = 0;

	public static void increment() {
		synchronized (question3.class) {
			int temp = sharedValue;
			temp++;

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedValue = temp;
		}
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
		System.out.println("Shared Value: " + sharedValue);
	}
}
