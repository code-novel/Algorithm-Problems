import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10282_해킹{
	public static int n,d,c;
	public static ArrayList<Node> list[];
	public static int[] dist;
	public static boolean[] visited;
	public static final int INF=Integer.MAX_VALUE;
	public static int cnt, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;++tc) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			list=new ArrayList[n+1];
			dist=new int[n+1];
			visited=new boolean[n+1];
			for(int i=1;i<n+1;++i) {
				list[i]=new ArrayList<>();
				dist[i]=INF;
			}
			for(int i=0;i<d;++i) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				list[b].add(new Node(a,Integer.parseInt(st.nextToken())));
			}
			dijkstra();
			cnt=0; max=0;
			for(int i=1;i<n+1;++i) {
				if(dist[i]!=INF) {
					cnt++;
					max=Math.max(max, dist[i]);
				}
			}
			System.out.println(cnt+" "+max);
		}
	}
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val-o2.val;
			}
		});
		dist[c]=0;
		pq.add(new Node(c,0));
		while(!pq.isEmpty()){
			Node n=pq.poll();
			if(visited[n.spot]) continue;
			visited[n.spot]=true;
			for(int i=0;i<list[n.spot].size();++i) {
				Node t=list[n.spot].get(i);
				int now=t.spot;
				int value=dist[n.spot]+t.val;
				if(value<dist[now]) {
					dist[now]=value;
					pq.add(new Node(now, dist[now]));
				}
			}
		}
	}
	public static class Node{
		int spot;
		int val;
		public Node(int s, int v) {
			this.spot=s;
			this.val=v;
		}
	}
}