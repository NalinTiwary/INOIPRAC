import java.io.*;
import java.util.*;

class Fence 
{
	private static class Point
	{
		int x,y;
		Point(int a,int b)
		{
			this.x=a;
			this.y=b;
		}
		
		public int hashCode()
        {
            return this.x+this.y;
        }
        public boolean equals(Object o)
        {
            Point p = (Point)o;
            if(this.x==p.x && this.y==p.y)
            {
                return true;
            }
            else
            { 
                return false;
            }
        }
	}
    
    private static int Int(String s) throws Exception
    {
    	return Integer.parseInt(s);
    }

    @SuppressWarnings("unused")
	public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split("\\s+");
        int R=Int(s[0]);
        int C=Int(s[1]);
        int N=Int(s[2]);
        long ans=0;
        Point cf[]=new Point[N];
        HashSet<Point> track=new HashSet<Point>();
        HashSet<Point> list=new HashSet<Point>();
        for(int i=0;i<N;i++)
        {
            s=br.readLine().split("\\s+");
        	cf[i]=(new Point(Int(s[0]),Int(s[1])));
        	track.add(cf[i]);
        	list.add(cf[i]);
        }
        
        Queue<Point> q=new LinkedList<Point>();
        int count=0;
        for(int i=0;i<N;i++)
        {
        	count=0;
	        q.add(cf[i]);
	        while(!q.isEmpty())
	        {
	        	Point temp=q.poll();
	        	if(!track.contains(temp))
	        	{
	        		continue;
	        	}
	        	track.remove(temp);
	        	int x=temp.x;
	        	int y=temp.y;
	        	if(x==1 || !list.contains(new Point(x-1,y)))
	        	{
	        		count++;
	        	}
	        	if(y==1 || !list.contains(new Point(x,y-1)))
	        	{
	        		count++;
	        	}	        	
	        	if(x==R || !list.contains(new Point(x+1,y)))
	        	{
	        		count++;
	        	}
	        	if(y==C || !list.contains(new Point(x,y+1)))
	        	{
	        		count++;
	        	}
	        	
	        	if(x!=1 && track.contains(new Point(x-1,y)))
	        	{
	        		q.add(new Point(x-1,y));
	        	}
	        	if(y!=1 && track.contains(new Point(x,y-1)))
	        	{
	        		q.add(new Point(x,y-1));
	        	}
	        	if(x!=R && track.contains(new Point(x+1,y)))
	        	{
	        		q.add(new Point(x+1,y));
	        	}
	        	if(y!=C && track.contains(new Point(x,y+1)))
	        	{
	        		q.add(new Point(x,y+1));
	        	}
	        }
	        ans=Math.max(ans,count);
        }
        System.out.println(ans);
    }
}
