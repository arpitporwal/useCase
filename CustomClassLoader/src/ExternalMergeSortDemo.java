package assignment.part1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

class ExternalMergerSort
{
	int ram_size=250;
	int file_size=100;
	int num_of_files=10;
	
	public void externalMergeSort(String[] filenames) throws IOException
	{
		int buffereddata[]=new int[ram_size];
		int num_of_records=0;
		for(int i=0;i< filenames.length;i++)
		{
			FileReader fr=new FileReader(filenames[i]);
			BufferedReader br=new BufferedReader(fr);
			int j=0;
			while(br.lines() != null)
			{
				String temp=br.readLine();
				//System.out.println("temp val:"+temp);
				if(temp!=null)
				{
					buffereddata[j++]=Integer.parseInt(temp);
					num_of_records++;
				}
				else
					break;	
			}
			int tempArr[]=new int[j];
			for(int l=0;l<j;l++)
			{
				tempArr[l]=buffereddata[l];
			}
			//System.out.println();
			Arrays.sort(tempArr);
			br.close();
			fr.close();
			File ftemp=new File("C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\tempfile_"+i+".txt");
				ftemp.createNewFile();
			FileWriter fw=new FileWriter(ftemp);
			BufferedWriter bw=new BufferedWriter(fw);
			for(int l=0;l<j;l++)
			{
				bw.write(tempArr[l]+"");
				bw.newLine();
				
			}
			bw.close();
			fw.close();
		}
		
		int maxNumsArray[]=new int[num_of_files];
		BufferedReader []bufferread=new BufferedReader[file_size];
		
		for(int i=0;i<filenames.length;i++)
		{
			bufferread[i]=new BufferedReader(new FileReader("C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\tempfile_"+i+".txt"));
			String temp=bufferread[i].readLine();
			if(temp!=null)
				maxNumsArray[i]=Integer.parseInt(temp);
			else
				maxNumsArray[i]=Integer.MAX_VALUE;			
		}
		
		File f=new File("C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\sorted_file.txt");
		if(!f.exists())
			f.createNewFile();
		FileWriter fwssorted=new FileWriter(f);
		BufferedWriter bwsorted=new BufferedWriter(fwssorted);
		for(int m=0;m<num_of_records;m++)
		{	
			int min=maxNumsArray[0];
			int minindex=0;
			for(int k=1;k<filenames.length;k++)
			{
				if(min>maxNumsArray[k])
				{
					min=maxNumsArray[k];
					minindex=k;
				}
			}
			
			bwsorted.write(min+"");
			bwsorted.newLine();
			String temp=null;
				temp=bufferread[minindex].readLine();
		if(temp!=null)
			maxNumsArray[minindex]=Integer.parseInt(temp);
		else
			maxNumsArray[minindex]=Integer.MAX_VALUE;
		}
		bwsorted.close();
		fwssorted.close();
	}
	
}

public class ExternalMergeSortDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String file_1="C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\file_1.txt";
		String file_2="C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\file_2.txt";
		String file_3="C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\file_3.txt";
		String file_4="C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\file_4.txt";
		String file_5="C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\file_5.txt";
		String[] filenames= {file_1,file_2,file_3,file_4,file_5};
		
		ExternalMergerSort externalsort=new ExternalMergerSort();
		externalsort.externalMergeSort(filenames);
		
		String sorted_file="C:\\Users\\Dixit\\Desktop\\MergeSortFiles\\sorted_file.txt";
		
		BufferedReader br=new BufferedReader(new FileReader(sorted_file));
		while(br.lines() != null)
		{
			String temp=br.readLine();
			if(temp!=null)
				System.out.println(temp);
			else break;
		}
		br.close();
			

	}

}
