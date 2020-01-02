package Nalin;
import java.util.*;
import java.io.*;
class CalvinGame 
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
    
	public static void main(String[] args) throws Exception
	{
		int N=Int();
		int K=Int()-1;
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=Int();
		}
		long dp[]=new long[N];
		Arrays.fill(dp,Integer.MIN_VALUE);
		dp[K]=0;
		for(int i=K;i<N-1;i++)
		{
			dp[i+1]=Math.max(dp[i+1],dp[i]+arr[i+1]);
			if(i!=N-2)
			{
				dp[i+2]=Math.max(dp[i+2],dp[i]+arr[i+2]);
			}
		}
		for(int i=N-1;i>0;i--)
		{
			dp[i-1]=Math.max(dp[i-1],dp[i]+arr[i-1]);
			if(i!=1)
			{
				dp[i-2]=Math.max(dp[i-2],dp[i]+arr[i-2]);
			}
		}
		System.out.println(dp[0]);
	}
}
