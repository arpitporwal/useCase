package practice.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingLockCondition {
	public static void main(String[] args) {
		ProducerConsumerImpl sharedObject = new ProducerConsumerImpl();
		Producer p = new Producer(sharedObject);
		Consumer c = new Consumer(sharedObject);
		c.start();
		p.start();
	}
}

class Producer extends Thread
{
	ProducerConsumerImpl pc = null;
	
	public Producer(ProducerConsumerImpl sharedObject)
	{
		this.pc = sharedObject;
	}
	
	@Override
	public void run() {
		try
		{
			int i=0;
			while(i<5)
			{
				pc.produce();
				i++;
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}

class Consumer extends Thread
{
	ProducerConsumerImpl pc = null;
	
	public Consumer(ProducerConsumerImpl sharedObject)
	{
		this.pc = sharedObject;
	}
	
	@Override
	public void run() {
		try
		{
			int i=0;
			while(i<5){
				pc.consume();
				i++;
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}

class ProducerConsumerImpl
{
	private static final int CAPACITY = 10;
	private final Queue<Integer> queue = new LinkedList<>();
	private final Random random = new Random();
	
	private final Lock aLock = new ReentrantLock();
	private final Condition bufferNotFull = aLock.newCondition();
	private final Condition bufferNotEmpty = aLock.newCondition();
	
	public void produce() throws InterruptedException
	{
		aLock.lock();
		try
		{
			while(queue.size() == CAPACITY)
			{
				System.out.println("Buffer is full - waiting");
				bufferNotEmpty.await();
			}
			if(queue.size() == 0)
			{
				bufferNotFull.signalAll();
			}
			int input = random.nextInt();
			queue.offer(input);
			System.out.println("Produced : "+input);
		}
		finally
		{
			aLock.unlock();
		}
	}
	
	public void consume() throws InterruptedException
	{
		aLock.lock();
		try
		{
			while(queue.size() == 0)
			{
				System.out.println("Buffer is Empty - waiting");
				bufferNotFull.await();
			}
			if(queue.size() == CAPACITY)
			{
				bufferNotEmpty.signalAll();
			}
			int output = queue.poll();
			System.out.println("Consumed : "+output);
		}
		finally
		{
			aLock.unlock();
		}
	}
}