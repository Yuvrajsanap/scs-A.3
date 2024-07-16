package prioritythread;

class PriorityThread extends Thread {
	public PriorityThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(getName() + " with priority " + getPriority() + " is running.");
		}
	}

	public static void main(String[] args) {
		PriorityThread t1 = new PriorityThread("Thread 1");
		PriorityThread t2 = new PriorityThread("Thread 2");
		PriorityThread t3 = new PriorityThread("Thread 3");

		// Set different priorities
		t1.setPriority(Thread.MIN_PRIORITY); // Priority 1
		t2.setPriority(Thread.NORM_PRIORITY); // Priority 5
		t3.setPriority(Thread.MAX_PRIORITY); // Priority 10

		t1.start();
		t2.start();
		t3.start();
	}
}
