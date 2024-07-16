package synchronization;

class question2 {
	private int count = 0;

	// Method without synchronization
	public void incrementWithoutSync() {
		count++;
	}

	public synchronized void incrementWithSync() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		question2 instanceWithoutSync = new question2();
		question2 instanceWithSync = new question2();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instanceWithoutSync.incrementWithoutSync();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instanceWithoutSync.incrementWithoutSync();
			}
		});

		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instanceWithSync.incrementWithSync();
			}
		});

		Thread t4 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				instanceWithSync.incrementWithSync();
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

		System.out.println("Final count without synchronization: " + instanceWithoutSync.getCount());
		System.out.println("Final count with synchronization: " + instanceWithSync.getCount());
	}
}
