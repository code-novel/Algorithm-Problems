import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14938_서강그라운드{
	public static int n, m, r;
	public static int item[];
	public static final int INF=Integer.MAX_VALUE;
	public static ArrayList<Node> list[];
	public static int d[];
	public static boolean visited[];
	public static int max=0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		item=new int[n+1];
		list=new ArrayList[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;++i) {
			item[i]=Integer.parseInt(st.nextToken());
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<r;++i) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,v));
			list[b].add(new Node(a,v));
		}
		for(int i=1;i<=n;++i) {
			d=new int[n+1];
			Arrays.fill(d, INF);
			visited=new boolean[n+1];
			dijkstra(i);
			int score=0;
			for(int j=1;j<=n;++j) {
				if(d[j]<=m) {
					score+=item[j];
				}
			}
			max=Math.max(max, score);
		}
		System.out.println(max);
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.val-o2.val;
			}
		});
		d[start]=0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			if(visited[n.spot])continue;
			visited[n.spot]=true;
			for(int i=0;i<list[n.spot].size();++i) {
				int now=list[n.spot].get(i).spot;
				int val=list[n.spot].get(i).val+d[n.spot];
				if(val<d[now]) {
					d[now]=val;
					pq.add(new Node(now, d[now]));
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
