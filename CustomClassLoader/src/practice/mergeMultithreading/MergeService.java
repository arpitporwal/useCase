package practice.mergeMultithreading;

public class MergeService
{
	private int arr[];
	private int left;
	private int right;
	private int mid;
	
	public MergeService(int[] arr, int left, int right)
	{
		this.arr = arr;
		this.left = left;
		this.mid = (right - left)/2;
		this.right = right;
	}
	
	public int[] getArray()
	{
		return this.arr;
	}
	
	public void merge()
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
