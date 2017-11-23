package practice;

public class LambdaTest
{
	public static void main(String[] args)
	{
		FunctionalInterfaceTest test = (i, j) -> (i+j);
		
		System.out.println(test.sum(10, 20));
		
	}
}

@FunctionalInterface
interface FunctionalInterfaceTest
{
	public int sum(int i, int j);
}
