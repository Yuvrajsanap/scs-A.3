package prexample;

public class question1 extends Thread {
	public void run() {
		System.out.println("Thread is running.");
	}

	public static void main(String[] args) {
		question1 thread = new question1();
		thread.start();
	}
}
