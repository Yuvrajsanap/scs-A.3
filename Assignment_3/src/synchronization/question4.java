package synchronization;

//wait method
class WaitExample {
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

class ProducerWait extends Thread {
	private WaitExample resource;

	public ProducerWait(WaitExample resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.produce();
	}
}

class ConsumerWait extends Thread {
	private WaitExample resource;

	public ConsumerWait(WaitExample resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		resource.consume();
	}
}

public class question4 {
	public static void main(String[] args) {
		WaitExample resource = new WaitExample();
		ProducerWait producer = new ProducerWait(resource);
		ConsumerWait consumer = new ConsumerWait(resource);

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
