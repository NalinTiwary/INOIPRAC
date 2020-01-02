package Nalin;
import java.io.*;
import java.util.*;

public class WealthDisp 
{
	static StringTokenizer st;
    static BufferedReader br;
    static int boss;
    static ArrayList<Integer> arr[];
    static int a[];
    static int p[];
    static long dp[];
    static long ans=Integer.MIN_VALUE;
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
    
    private static void DFS(int i)
    {
    	dp[i]=Integer.MAX_VALUE;
    	for(int k:arr[i])
    	{
    		dp[i]=Math.min(dp[i], Math.min(dp[k],a[k]));
    		DFS(k);		
    	}
    	ans=Math.max(ans,dp[i]);
    }
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		int N=Int();
		a=new int[N];
		p=new int[N];
		dp=new long[N];
		arr=new ArrayList[N];
		for(int i=0;i<N;i++)
		{
			a[i]=Int();
			arr[i]=new ArrayList<Integer>(N);
		}
		for(int i=0;i<N;i++)
		{
			p[i]=Int()-1;
			if(p[i]==-2)
			{
				boss=i;
			}
			else
			{
				arr[p[i]].add(i);
			}
		}
		DFS(boss);
		System.out.println(ans);
	}
}
