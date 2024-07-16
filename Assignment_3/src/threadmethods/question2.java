package threadmethods;

class question2 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running.");
	}

	public static void main(String[] args) {
		question2 thread1 = new question2();
		thread1.run();
	}
}
