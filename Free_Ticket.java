package Nalin;
import java.util.*;
import java.io.*;
class Free_Ticket
{
    static StringTokenizer st;
    static BufferedReader br;
    static int graph[][];
    static int sum;
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

    private static int minDist(int dist[], boolean visit[])
    {
        int ind=-1;
        int min=sum+1;
        for(int i=0;i<dist.length;i++)
        {
            if(min>=dist[i] && !visit[i])
            {
                min=dist[i];
                ind=i;
            }
        }
        return ind;
    }

    public static void main(String args[]) throws Exception
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        int n=Int();
        int F=Int();
        @SuppressWarnings("unchecked")
		ArrayList<Integer> arr[]=new ArrayList[n];
        graph=new int[n][n];
        for(int i=0;i<n;i++)
        {
        	arr[i]=new ArrayList<Integer>();
        }
        sum=0;
        for(int j=0;j<F;j++)
        {
        	int U=Int()-1;
        	int V=Int()-1;
        	int P=Int();
        	arr[U].add(V);
        	arr[V].add(U);
        	graph[U][V]=P;
        	graph[V][U]=P;
        	sum+=P;
        }

        int src=0;
        int Distance[]=new int[n];
        boolean Visited[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            Visited[i]=false;
            Distance[i]=sum+1;
        }
        
        Distance[src]=0;
        for(int i=0;i<n;i++)
        {
            int u=minDist(Distance,Visited);
            Visited[u]=true;
            for(int j=0;j<arr[u].size();j++)
            {
                int temp=arr[u].get(j);
                if(!Visited[temp] && Distance[temp]>=Distance[u]+graph[u][temp])
                {
                    Distance[temp]=Distance[u]+graph[u][temp];
                }
            }
        }
        Arrays.sort(Distance);
        System.out.println(Distance[n-1]);
    }
}
