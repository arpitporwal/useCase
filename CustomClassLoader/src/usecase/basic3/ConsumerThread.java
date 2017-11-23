package usecase.basic3;

public class ConsumerThread extends Thread
{
	private BlockingQueue bQueue;
	
	public ConsumerThread(BlockingQueue bQueue)
	{
		this.bQueue = bQueue;
	}
	
	public void run()
	{
		for(int i=0; i<50; i++)
		{
			System.out.println("Consumed : "+bQueue.dequeue()+" by : "+Thread.currentThread().getName());
		}
	}
}
