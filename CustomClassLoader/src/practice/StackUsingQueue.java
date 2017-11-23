package practice;

public class StackUsingQueue {
	
	Queue q1 = new Queue(10);
	Queue q2 = new Queue(10);
	
	public void push(Object item)
	{
		this.q1.enqueue(item);
	}
	
	public Object pop()
	{
		int size = q1.size();
		for(int i=0; i < size - 1; i++)
		{
			q2.enqueue(q1.dequeue());
		}
		Object o = q1.dequeue();
		Queue tmp = q1;
		q1 = q2;
		q2 = tmp;
		return o;
	}
	
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
