package practice;

public class StaticBlock {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.toString());
	}
}

class A
{
	static{
		System.out.println(1);
	}
	{
		System.out.println(2);
	}
	A()
	{
		System.out.println(3);
	}
}
class B extends A
{
	static{
		System.out.println(4);
	}
	{
		System.out.println(5);
	}
	B()
	{
		System.out.println(6);
	}
}
