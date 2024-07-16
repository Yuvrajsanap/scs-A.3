package synchronization;

class question1 {
	private int count = 0;

	// Synchronized method to increment the counter
	public synchronized void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		question1 counter = new question1();

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					counter.increment();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					counter.increment();
				}
			}
		});

		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final counter value: " + counter.getCount());
	}
}
