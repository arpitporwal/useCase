package usecase.advanced1;

import java.util.ArrayList;
import java.util.List;

public class CustomExecutorService {
	
	private List<Taskable<T>> tasks = null;
	public CustomExecutorService()
	{
		tasks = new ArrayList<Taskable<T>>();
	}
	
	public CustomFuture<T> add(Taskable<T> task)
	{
		tasks.add(task);
		return null;
	}
}
