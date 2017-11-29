package practice.mergeMultithreading;

import java.util.concurrent.CountDownLatch;


public class MergeSort
{
	public static void main(String[] args)
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		int left = 0;
		int right = arr.length;
		int mid = (left + right) / 2;
		
		Thread t = new Thread(new Runnable(){
			@Override
			public void run()
			{
				CountDownLatch latch = new CountDownLatch(2);
				MergeSort.divide(arr, left, mid, latch);
				MergeSort.divide(arr, mid+1, right, latch);
			}
		});
				
		t.start();
	}
	
	private static void divide(int[] arr, int start, int end, CountDownLatch latch)
	{
		if(start < end)
		{
			int mid = (start + end) / 2;
			Thread t1 = new Thread(new Runnable(){
				@Override
				public void run()
				{
					CountDownLatch latch = new CountDownLatch(2);
					MergeSort.divide(arr, start, mid, latch);
				}
			});
			t1.start();
			
			Thread t2 = new Thread(new Runnable(){
				@Override
				public void run()
				{
					CountDownLatch latch = new CountDownLatch(2);
					MergeSort.divide(arr, mid+1, end, latch);
				}
			});
			t2.start();
			try
			{
				
				latch.await();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void merge(int[] arr, int left, int mid, int right)
	{
		int lSize = mid - left + 1;
		int rSize = right - mid;
		
		int lArray[] = new int[lSize];
		for(int i=0; i<lSize; i++)
		{
			lArray[i] = arr[left + i];
		}
		
		int rArray[] = new int[rSize];
		for(int i=0; i<rSize; i++)
		{
			rArray[i] = arr[mid + i + 1];
		}
		
		int i=0,j=0,k=left;
		
		while(i<lSize && j<rSize)
		{
			if(lArray[i] <= rArray[j])
			{
				arr[k] = lArray[i];
				i++;
			}
			else
			{
				arr[k] = rArray[j];
				j++;
			}
			k++;
		}
		
		while(i<lSize)
		{
			arr[k] = lArray[i];
			i++; k++;
		}
		
		while(j<rSize)
		{
			arr[k] = rArray[j];
			j++; k++;
		}
	}
	
}
