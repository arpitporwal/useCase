package usecase.basic5;

public class FibonacciNonRecursive {
	public static void main(String[] args) {
		fib(8);
	}
	
	public static void fib(int number)
	{
		if(number < 2)
		{
			System.out.println("Invalid Number");
		}
		int i=0, j=1;
		int k;
		System.out.println(0);
		System.out.println(1);
		while(number > 2)
		{
			k=i+j;
			System.out.println(k);
			i=j;
			j=k;
			number--;
		}
		
	}
}
