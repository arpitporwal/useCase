package usecase.basic4;

public class MergeSort {

	public static void main(String[] args)
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort.mergeSort(arr, 0, arr.length-1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
	
	private static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
	public static void mergeSort(int[] arr, int start, int end)
	{
		if(start < end)
		{
			int mid = (start + end)/2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			
			merge(arr, start, mid, end);
		}
	}
	
	private static void merge(int[] arr, int left, int mid, int right)
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
