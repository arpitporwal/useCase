package usecase.advanced1;

public interface Taskable<T> {
	public CustomFuture<T> task(); 
}
HashSet