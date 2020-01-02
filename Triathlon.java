package Nalin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Triathlon 
{

	static StringTokenizer st;
    static BufferedReader br;
    private static String next() throws Exception
    {
        while(st==null || !st.hasMoreElements())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    
    private static Long Long() throws Exception
    {
    	return Long.parseLong(next());
    }
    
	public static void main(String[] args) throws Exception
	{
		try
		{
			br=new BufferedReader(new InputStreamReader(System.in));
			int N=Integer.parseInt(next());
			Long arr[][]=new Long[N][2];
			for(int i=0;i<N;i++)
			{
				arr[i][0]=Long();
				arr[i][1]=Long()+Long();
			}
			Arrays.sort(arr, new Comparator<Long[]>()
					{
						public int compare(Long a[],Long b[])
						{
							return -a[1].compareTo(b[1]);
						}
					}
					);
			Long time=arr[0][0]+arr[0][1];
			Long sum=arr[0][0];
			for(int i=1;i<N;i++)
			{
				sum+=arr[i][0];
				Long temp=sum+arr[i][1];
				if(temp>time)
				{
					time=temp;
				}
			}
			System.out.println(time);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}