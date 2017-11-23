package practice;

import java.util.Arrays;
import java.util.Collections;

public class Queue {
	Object[] arr;
	int limit;
	public Queue(int limit)
	{
		this.limit = limit;
		this.arr = new Object[limit]; 
	}
	
	int front = 0;
	int rear = 0;
	public void enqueue(Object item)
	{
		if(front > limit  && rear == 0)
		{
			System.out.println("No space to enqueue");
			return;
		}
		if(front > limit)
		{
			front = front % limit;
		}
		arr[front++] = item;
	}
	public Object dequeue()
	{
		if(isEmpty())
		{
			System.out.println("No item to dequeue");
			return null;
		}
		if(rear > limit)
		{
			rear = rear % limit;
		}
		Object item = arr[rear++];
	
		return item;
	}
	
	public int size()
	{
		return (front > rear) ? (front - rear) : limit - (rear - front);
	}
	
	public boolean isEmpty()
	{
		if(front == rear)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(10);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
