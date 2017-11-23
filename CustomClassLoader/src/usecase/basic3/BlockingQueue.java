package usecase.basic3;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue {
	
	private int limit;
	private List<Object> queue;
	
	public BlockingQueue(int limit)
	{
		this.limit = limit;
		this.queue = new ArrayList<Object>(limit);
	}
	
	public synchronized void enqueue(Object item)
	{
		while(this.queue.size() == this.limit)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(this.queue.size() == 0)
		{
			this.notifyAll();
		}
		this.queue.add(item);
	}
	
	public synchronized int dequeue()
	{
		while(this.queue.size() == 0)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(this.queue.size() == this.limit)
		{
			this.notifyAll();
		}
		Object o = queue.get(0);
		queue.remove(0);
		return (int)o;
	}
}
