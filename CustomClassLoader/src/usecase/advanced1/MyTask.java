package usecase.advanced1;

public class MyTask implements Taskable<Integer>{

	@Override
	public CustomFuture<Integer> task() {
		// TODO Process the task
		CustomFuture<Integer> f = new CustomFuture<Integer>();
		return f;
	}
	
}
