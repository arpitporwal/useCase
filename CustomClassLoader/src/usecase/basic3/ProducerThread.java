package usecase.basic3;

public class ProducerThread extends Thread{
	
	private BlockingQueue bQueue;
	
	public ProducerThread(BlockingQueue bQueue)
	{
		this.bQueue = bQueue;
	}
	
	@Override
	public void run()
	{
		for(int i=0; i<50; i++)
		{
			System.out.println("Produced: "+i+" by : "+Thread.currentThread().getName());
			bQueue.enqueue(i);
		}
	}
}
