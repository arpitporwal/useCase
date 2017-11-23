package practice;

import java.util.HashMap;
import java.util.Map;

public class ImmutableKey {
	public static void main(String[] args) {
		Map<Employee, String> map = new HashMap<>();
		Employee e1 = new Employee(1, "A", 10);
		Employee e2 = new Employee(2, "B", 20);
		Employee e3 = new Employee(3, "C", 30);
		
		map.put(e1, "1");
		map.put(e2, "1");
		map.put(e3, "1");
		
		e2.setName("D");
		
		System.out.println(map.get(e2));
	}
}
