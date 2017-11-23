package practice.advanced2;

import java.util.concurrent.CountDownLatch;

public class ClassRoom {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cdl = new CountDownLatch(2);
		Student s1 = new Student(cdl);
		Student s2 = new Student(cdl);
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);

		t1.start();
		t2.start();
		
		System.out.println("Waiting to Join at least two Students");
		cdl.await();
		System.out.println("The session is started.");
		
	}
	
	
}

class Student implements Runnable
{
	CountDownLatch latch = null;
	public Student(CountDownLatch cdl)
	{
		this.latch = cdl;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Student "+Thread.currentThread().getName()+" Arrives in Classroom");
		latch.countDown();
	}
}
