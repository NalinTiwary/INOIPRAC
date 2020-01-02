package Nalin;

import java.io.*;
import java.util.*;

class SeqLand 
{
	static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int size=1;
    static int K,N;
    static String id[];
    
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
    
    private static void Relative(String s,int index)
    {
    	id[index]="-1";
    	for(int i=0;i<N;i++)
    	{
    		if(id[i].equals("-1"))
    		{
    			continue;
    		}
    		else
    		{
    			String arr[]=id[i].split("\\s+");
    			int temp=0;
    			for(int j=0;j<arr.length;j++)
    			{
    				if(s.contains(arr[j]))
    				{
    					temp++;
    				}
    			}
    			if(temp>=K)
    			{
    				size++;
    				Relative(id[i],i);
    			}
    		}
    	}
    }
    
	public static void main(String[] args) throws Exception
	{
		N=Int();
		K=Int();
		id=new String[N];
		for(int i=0;i<N;i++)
		{
			String temp=br.readLine();
			id[i]=temp.substring(temp.indexOf(" ")+1);
		}
		Relative(id[0],0);
		System.out.println(size);
	}
}
