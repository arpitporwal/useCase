package usecase.basic3;

/*Implement producer/consumer problem Using custom blocking queue, join, semaphore and wait/notify.*/

public class MainClass {
	public static void main(String[] args) {
		BlockingQueue bq = new BlockingQueue(5);
		
	//	for(int i=0; i<10; i++)
	//	{
			ProducerThread producer = new ProducerThread(bq);
			ConsumerThread consumer = new ConsumerThread(bq);
			producer.start();
			consumer.start();
	//	}
	}
}
