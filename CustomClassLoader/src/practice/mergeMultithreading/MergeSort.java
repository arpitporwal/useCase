package practice.mergeMultithreading;

import java.util.concurrent.CountDownLatch;


public class MergeSort
{
	public static void main(String[] args)
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		int left = 0;
		int right = arr.length;
		
		
		while(left < right)
		{
			CountDownLatch latch = new CountDownLatch(2);
			int mid = (left + right)/ 2;
			
			MergeService mergeService1 = new MergeService(arr, left, mid-1);
			MergeService mergeService2 = new MergeService(arr, mid, right);
			
			SortThread st1 = new SortThread(mergeService1, latch);
			SortThread st2 = new SortThread(mergeService2, latch);
			
			try
			{
				latch.await();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			
		}
	}
}
