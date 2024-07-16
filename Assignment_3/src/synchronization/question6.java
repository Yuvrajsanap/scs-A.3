package synchronization;

class NotifyAllExample {
	private boolean available = false;

	public synchronized void produce() {
		System.out.println("Producing item...");
		available = true;
		notifyAll();
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

class ProducerNotifyAll extends Thread {
	private NotifyAllExample resource;

	public ProducerNotifyAll(NotifyAllExample resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.produce();
	}
}

class ConsumerNotifyAll extends Thread {
	private NotifyAllExample resource;

	public ConsumerNotifyAll(NotifyAllExample resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.consume();
	}
}

public class question6 {
	public static void main(String[] args) {
		NotifyAllExample resource = new NotifyAllExample();
		ProducerNotifyAll producer = new ProducerNotifyAll(resource);
		ConsumerNotifyAll consumer1 = new ConsumerNotifyAll(resource);
		ConsumerNotifyAll consumer2 = new ConsumerNotifyAll(resource);

		consumer1.start();
		consumer2.start();
		producer.start();

		try {
			producer.join();
			consumer1.join();
			consumer2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
