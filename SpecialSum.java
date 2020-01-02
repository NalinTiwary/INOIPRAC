package Nalin;

import java.io.*;
import java.util.*;

class SpecialSum
{
	static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    private static String next() throws Exception
    {
        while(st==null || !st.hasMoreElements())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    
    private static int Int() throws Exception
    {
    	return Integer.parseInt(next());
    }
    
    public static void main(String args[]) throws Exception
    {
    	int N=Int();
    	int a[]=new int[N];
    	int b[]=new int[N];
    	long sum[]=new long[N];
    	
    	for(int i=0;i<N;i++)
    	{
    		a[i]=Int();
    	}
    	sum[0]=b[0]=Int();
    	for(int i=1;i<N;i++)
    	{
    		b[i]=Int();
    		sum[i]=sum[i-1]+b[i];
    	}   	
    	long max1=a[0]-sum[0];
    	long max2=a[0];
    	long ans=a[0];
    	for(int i=1;i<N;i++)
    	{
    		ans=Math.max(ans,a[i]);
    		ans=Math.max(ans,max1+sum[i-1]+a[i]);
    		ans=Math.max(ans,max2+sum[N-1]-sum[i]+a[i]);
    		
    		max1=Math.max(max1,a[i]-sum[i]);
    		max2=Math.max(max2,a[i]+sum[i-1]);
    	}
    	System.out.println(ans);
    }
}
