package practice;

public class StaticNull {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		D d = null;
		d.m1();
	}
}

class D
{
	static void m1()
	{
		System.out.println("D");
	}
}
