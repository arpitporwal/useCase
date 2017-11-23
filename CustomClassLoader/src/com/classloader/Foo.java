package com.classloader;

public class Foo {
	public static void main(String[] args) throws Exception
	{
		System.out.println("For Constructor >>>"+args[0] +" "+ args[1]);
		Bar bar = new Bar(args[0], args[1]);
		bar.printCL();
	}
	
	public static void printCL()
	{
		System.out.println("Foo ClassLoader: "+Foo.class.getClassLoader());
	}
}
