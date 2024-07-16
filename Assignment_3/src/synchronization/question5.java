package synchronization;

class NotifyExample {
	private boolean available = false;

	public synchronized void produce() {
		System.out.println("Producing item...");
		available = true;
		notify();
	}

	public synchronized void consume() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumed item.");
		available = false;
	}
}

class ProducerNotify extends Thread {
	private NotifyExample resource;

	public ProducerNotify(NotifyExample resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.produce();
	}
}

class ConsumerNotify extends Thread {
	private NotifyExample resource;

	public ConsumerNotify(NotifyExample resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.consume();
	}
}

public class question5 {
	public static void main(String[] args) {
		NotifyExample resource = new NotifyExample();
		ProducerNotify producer = new ProducerNotify(resource);
		ConsumerNotify consumer = new ConsumerNotify(resource);

		consumer.start();
		producer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
