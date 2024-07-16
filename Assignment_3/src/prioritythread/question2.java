package prioritythread;

public class question2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Thread 1 with priority " + Thread.currentThread().getPriority() + " is running.");
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Thread 2 with priority " + Thread.currentThread().getPriority() + " is running.");
			}
		});

		Thread t3 = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Thread 3 with priority " + Thread.currentThread().getPriority() + " is running.");
			}
		});

		t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
		t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
		t3.setPriority(Thread.MAX_PRIORITY); // Priority 10
		t1.start();
		t2.start();
		t3.start();
	}
}
