package practice.trafficSignal;

public class MySignal implements Runnable{
	
	TrafficSignalProblem signal = null;
	
	MySignal(TrafficSignalProblem signal)
	{
		this.signal = signal;
	}
	
	@Override
	public void run() {
		
	}
	
	public static void main(String[] args) {
		TrafficSignalProblem signal = new TrafficSignalProblem();
		Thread t = new Thread(new MySignal(signal));
		t.start();
	}
}
