package prioritythread;
//Example Demonstrating ExecutorService, Callable, and Future

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class question3 {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<String> task = () -> {
			TimeUnit.SECONDS.sleep(2);
			return "Task completed";
		};

		Future<String> future = executorService.submit(task);

		try {

			String result = future.get();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
