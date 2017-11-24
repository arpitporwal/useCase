package usecase.stream.cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
1. find Automatic cars
2. find cars manufactured after x year
3. group all the cars based on manufactured company
4. sort based on the car price in ascending order and name in descending order
5. if car is manual and is manufactured after x year then increment the price by 10%
*/
public class MainClass
{
	public static void main(String[] args)
	{
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car(true, 2012, "Maruti", 100, "Dzire"));
		cars.add(new Car(false, 2010, "Maruti", 50, "alto"));
		cars.add(new Car(true, 2017, "Renault", 300, "Duster"));
		cars.add(new Car(false, 2015, "Mahindra", 200, "Gusto"));
		cars.add(new Car(true, 2016, "Maruti", 120, "Dzire"));
		cars.add(new Car(true, 2014, "VolksWagen", 100, "Vento"));
		cars.add(new Car(false, 2012, "Hyundai", 250, "i10"));
		cars.add(new Car(false, 2007, "Hyundai", 250, "i20"));
		
		Stream<Car> s1 = cars.stream().filter(a -> a.isAutomatic());
		System.out.println("1. AutoMatic Cars");
		s1.forEach(a -> System.out.println(a.getName()));
		
		System.out.println();
		
		int year = 2013;
		Stream<Car> s2 = cars.stream()
							 .filter(a -> a.getMfgYear() > year);
		System.out.println("2. cars manufactured after "+year);
		s2.forEach(a -> System.out.println(a.getName()));
		
		System.out.println();

		System.out.println("3. group all the cars based on manufactured company");
		Stream<Car> s3 = cars.stream();
		Map<String, Long> map = (Map<String, Long>) s3.collect(Collectors.groupingBy(a -> a.getCompany(), Collectors.counting()));
		map.forEach((a, b) -> System.out.println("Car Company: "+a+" Count: "+b));
		
		System.out.println();
		
		System.out.println("4. sort based on the car price in ascending order and name in descending order");
		Stream<Car> s4 = cars.stream().sorted((a, b) -> {
								 if(a.getPrice() == b.getPrice())
								 {
									 return (a.getName().compareTo(b.getName()) == 1 ? -1 : 1);
								 }
								 else
								 {
									 return (a.getPrice() < b.getPrice() ==  true ? 1 : -1);
								 }
							 });
		s4.forEach(a -> System.out.println(a.getName()+" "+a.getPrice()));
		
		System.out.println();
		
		int incPercent = 10;
		System.out.println("5. if car is manual and is manufactured after x year then increment the price by "+incPercent+"%");
		Stream<Car> s5 = cars.stream()
							 .filter(a -> a.isAutomatic() && a.getMfgYear() > 2013)
							 .map(a -> {
								a.setPrice(a.getPrice() + a.getPrice() * incPercent / 100);
								return a;
							 });
		s5.forEach(a -> System.out.println(a.getName()+" "+a.getPrice()));
		
		System.out.println();
	}
}
