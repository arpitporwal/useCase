package UseCaseProblems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;




class MergerSortUsingForkJoin extends RecursiveAction
{

	private static final long serialVersionUID = -6076361760934329497L;
	int low;
	int high;
	final ArrayList<Integer> arr;
	//final ArrayList<Integer> temp;
	public MergerSortUsingForkJoin(ArrayList<Integer> arr,int low,int high) {
		// TODO Auto-generated constructor stub
		this.arr=arr;
		
		this.low=low;
		this.high=high;
	}

	@Override
	protected void compute() {
		if(low>=high) return;
		int mid=low+(high-low)/2;
	
			MergerSortUsingForkJoin left=new MergerSortUsingForkJoin(arr,low,mid);
			MergerSortUsingForkJoin right=new MergerSortUsingForkJoin(arr, mid+1,high);
			left.fork();
			right.fork();
			 mergerList(arr,low,mid,high);
			left.join();
			right.join();
		
		
		
		
	}
	
	
	
	

	private synchronized void mergerList(ArrayList<Integer> arr, int low, int mid, int high) {
		ArrayList<Integer> temp=new ArrayList<Integer>();
		int i=low;
		int j=mid+1;
		while(i<=mid && j<=high)
		{
			if(arr.get(i)<arr.get(j))
			{
				temp.add(arr.get(i++));
			}
			else
			{
				temp.add(arr.get(j++));
			}
		}
		while(i<=mid)
		{
			temp.add(arr.get(i++));
		}
		while(j<=high)
		{
			temp.add(arr.get(j++));
		}
		int m=0;
		for(int l=low;l<=high;l++)
		{
			arr.set(l, temp.get(m++));
			//arr.replace(l, temp.get(m++));
		}
		
	}

	
}
public class MergerSortUsingForkJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr={3,5,10,15,4,9,11,45};
		ArrayList<Integer> ar=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			ar.add(arr[i]);
		}
		ForkJoinPool fp=new ForkJoinPool(4);
		//ArrayList<Integer> temp=new ArrayList<Integer>();
		MergerSortUsingForkJoin mergesort=new MergerSortUsingForkJoin(ar,0,ar.size()-1);
		fp.invoke(mergesort);
		
		
		for(int i=0;i<ar.size();i++)
		{
			System.out.print(ar.get(i)+" ");
		}
	
		
		

	}

}
