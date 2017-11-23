package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample {

	
	public static void main(String[] args) throws ClassNotFoundException
	{
		F f = new F();
		File file = new File("myObj.tmp");
		SerializationExample se = new SerializationExample();
		se.serialize(f, file);
		
		F f2 = (F)se.deserialize(file);
		System.out.println(f2.i);
		System.out.println(f2.j);
		System.out.println(f.equals(f2));
	}

	public void serialize(Serializable f, File file)
	{
		try{
			FileOutputStream fs = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fs);
			oos.writeObject(f);
			System.out.println("Object is Serialized.");
			oos.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Serializable deserialize(File file) throws ClassNotFoundException
	{
		Serializable f2 = null;
		try{
			
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            f2 = (Serializable)ois.readObject();
            System.out.println("Object is Deserialized.");
			ois.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return f2;
	}
	
}

class F implements Serializable
{
	private static final long serialVersionUID = 1L;
	String i = "Arpit";
	String j = "Porwal";
}