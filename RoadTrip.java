package Nalin;
import java.util.*;
import java.io.*;
class RoadTrip
{
	static StringTokenizer st;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int m;
    static int mus[];
    static ArrayList<Integer> adj[];
    static boolean Visited[];
	private static String next() throws Exception
    {
        while(st==null || !st.hasMoreElements())
        {
            st=new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
    
    private static int Int(String s) throws Exception
    {
    	return Integer.parseInt(s);
    }
    
    private static int Int() throws Exception
    {
    	return Integer.parseInt(next());
    }
    
    private static void DFS(int I)
    {
    	Visited[I]=true;
    	m+=mus[I];
    	for(int i=0;i<adj[I].size();i++)
    	{
    		if(!Visited[adj[I].get(i)])
    		{
    			DFS(adj[I].get(i));
    		}
    	}
    }
    @SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception
    {
    	int T=Int();
    	while(T-->0)
    	{
    		int N=Int();
    		int M=Int();
    		int K=Int();
    		adj=new ArrayList[N];
    		for (int i = 0; i < N; i++) 
    		{
                adj[i] = new ArrayList<Integer>();
            }
    		for(int i=0;i<M;i++)
    		{
    			int a=Int()-1;
    			int b=Int()-1;
    			adj[a].add(b);
    			adj[b].add(a);
    		}
    		mus=new int[N];
    		Visited=new boolean[N];
    		String s[]=new String[N];
    		s=br.readLine().split("\\s+");
    		for(int i=0;i<N;i++)
    		{
    			mus[i]=Int(s[i]);
    			Visited[i]=false;
    		}
    		ArrayList<Integer> total=new ArrayList<Integer>();
    		for(int i=0;i<N;i++)
    		{
    			if(!Visited[i])
    			{
	    			m=0;
	    			DFS(i);
	    			total.add(m);
    			}
    		}
    		if(total.size()<K)
    		{
    			System.out.println("-1");
    		}
    		else
    		{
	    		Collections.sort(total);
	    		int ans=0;
	    		for(int i=0;i<K/2;i++)
	    		{
	    			ans+=total.get(i)+total.get(total.size()-1-i);
	    		}
	    		if(K%2==1)
	    		{
	    			ans+=total.get(total.size()-1-(K/2));
	    		}
	    		System.out.println(ans);
    		}
       	}
    }
}