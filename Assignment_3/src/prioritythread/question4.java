package prioritythread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class question4 {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		// Create a list of Callable tasks
		List<Callable<Integer>> tasks = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			tasks.add(() -> {
				return taskId * taskId;
			});
		}

		try {

			List<Future<Integer>> results = executorService.invokeAll(tasks);

			for (Future<Integer> result : results) {
				System.out.println("Result: " + result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
