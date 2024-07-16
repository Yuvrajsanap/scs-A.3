package threadmethods;

class question1 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running.");
	}

	public static void main(String[] args) {
		question1 thread1 = new question1();
		thread1.start();
	}
}
