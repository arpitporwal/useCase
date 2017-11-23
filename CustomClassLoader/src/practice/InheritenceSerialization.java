package practice;

import java.io.File;
import java.io.Serializable;

public class InheritenceSerialization {
	public static void main(String[] args) throws ClassNotFoundException {
		H h = new H();
		SerializationExample se = new SerializationExample();
		File file = new File("myObj.tmp");
		se.serialize(h, file);
		
		H h2 = (H) se.deserialize(file);
		
	}
}

class G
{
	G()
	{
		System.out.println(1);
	}
}

class H extends G implements Serializable
{
	H()
	{
		System.out.println(2);
	}
}
