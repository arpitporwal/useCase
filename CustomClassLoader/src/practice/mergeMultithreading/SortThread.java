package practice.mergeMultithreading;

import java.util.concurrent.CountDownLatch;

public class SortThread extends Thread
{
	private MergeService ms = null;
	private CountDownLatch latch = null;
	public SortThread(MergeService ms, CountDownLatch latch)
	{
		this.latch = latch;
		this.ms = ms;
	}
	
	@Override
	public void run()
	{
		synchronized (ms.getArray())
		{
			this.ms.merge();
			latch.countDown();
		}
	}
}