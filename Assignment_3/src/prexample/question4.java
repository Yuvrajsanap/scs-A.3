package prexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class question4 {
	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 5; i++) {
			Runnable task = new WorkerThread("Task " + i);
			executor.execute(task);
		}

		executor.shutdown();
	}
}

class WorkerThread implements Runnable {
	private final String taskName;

	public WorkerThread(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing " + taskName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(taskName + " completed");
	}
}
