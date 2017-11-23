package practice;

public class Test {
	public static void main(String[] args) {
		//new Y();
		Long[] i = new Long[100000000];
		for(long j=0; j<100000000; j++)
		{
			i[(int)j] = new Long(j);
			i[(int)j].toString().intern();
		}
	}
}

class X
{
	public X()
	{
		f();
	}
	public void f()
	{
		System.out.println("Hi");
	}
}

class Y extends X
{
	int x;
	{x=10;
	}
	
	public Y()
	{
		System.out.println("Hello");
	}
	public void f()
	{
		System.out.println(x);
	}
}
