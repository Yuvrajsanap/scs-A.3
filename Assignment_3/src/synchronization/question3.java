package synchronization;

class question3 {
	private int count = 0;
	private final Object lock = new Object();

	// Synchronized method
	public synchronized void incrementWithSyncMethod() {
		count++;
	}

	// Method with synchronized block
	public void incrementWithSyncBlock() {
		synchronized (lock) {
			count++;
		}
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		question3 instance = new question3();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instance.incrementWithSyncMethod();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instance.incrementWithSyncMethod();
			}
		});

		// Create multiple threads using synchronized block
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instance.incrementWithSyncBlock();
			}
		});

		Thread t4 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instance.incrementWithSyncBlock();
			}
		});

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final count: " + instance.getCount());
	}
}
