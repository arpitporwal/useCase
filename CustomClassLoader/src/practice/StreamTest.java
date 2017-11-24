package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest
{
	public static void main(String[] args) throws InterruptedException
	{
		List<String> list = Arrays.asList("a1", "a3", "b3", "b2", "a2", "c3", "b1", "c2", "a0");
		Stream<String> s = list.stream()
		 .filter(a -> {
			 System.out.println("Inside Filter for "+a);
			 return a.charAt(1) > '1';
		 })
		 .map((a) -> {
			 System.out.println("Inside Map "+a);
			 return a.toUpperCase();
		 })
		 .sorted((a, b) -> {
			 return a.compareTo(b);
		 });
		Thread.sleep(1000);
		s.forEach(System.out::print);
		
	//	 .collect(Collectors.toList());
	//	 .forEach(s -> System.out.print(s+" "));
	//   Output : A1 A2 A3 B1 B2 B3 C2 C3 
	}
}