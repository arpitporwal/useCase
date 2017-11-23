package practice.trafficSignal;


public class TrafficSignalProblem
{
	boolean north = false;
	boolean south = true;
	boolean east = false;
	boolean west = false;
	
	public synchronized void setNorth()
	{
		try
		{
			while(south || east || west)
			{
				this.wait();
			}
		}catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("North is Green");
		
		north = false;
		notifyAll();
	}
	
	public synchronized void setSouth()
	{
		try
		{
			while(north || east || west)
			{
				this.wait();
			}
		}catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("South is Green");
		
		south = false;
		notifyAll();
	}
	
	public synchronized void setEast()
	{
		try
		{
			while(south || north || west)
			{
				this.wait();
			}
		}catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("East is Green");
		
		east = false;
		notifyAll();
	}
	
	public synchronized void setWest()
	{
		try
		{
			while(south || east || north)
			{
				this.wait();
			}
		}catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("West is Green");
		
		west = false;
		notifyAll();
	}
}