import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10217_KCMTravel {
	public static int T, N, M, K;
	public static ArrayList<Node> list[];
	public static int [][]dist;
	public static final int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		T=Integer.parseInt(st.nextToken());
		for(int tc=0;tc<T;++tc) {
			st =new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			list=new ArrayList[N+1];
			dist=new int[N+1][M+1];
			for(int i=1;i<=N;++i) {
				list[i]=new ArrayList<Node>();
				Arrays.fill(dist[i],INF);
			}
			for(int i=0;i<K;++i) {
				st =new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				int v=Integer.parseInt(st.nextToken());
				list[a].add(new Node(b,v,c));
			}
			dijkstra();
			int res=INF;
			for(int i = 1; i <= M; i++)
		           res = Math.min(res, dist[N][i]);
			if(res==INF)
				System.out.println("Poor KCM");
			else
				System.out.println(res);
		}
	}
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.val==o2.val)
					return o1.cost-o2.cost;
				return o1.val-o2.val;
			}
		});
		dist[1][0]=0;
		pq.add(new Node(1,0,0));
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			if(n.dot==N) break;
			if(dist[n.dot][n.cost] < n.val) continue;
			dist[n.dot][n.cost]=n.val;
			for(int i=0;i<list[n.dot].size();++i) {
				Node t=list[n.dot].get(i);
				int Tcost=n.cost+t.cost;
				int Tval=n.val+t.val;
				if(Tcost>M) continue;
				if(dist[t.dot][Tcost]>Tval) {
					for(int j=Tcost;j<=M;++j) {
						if(dist[t.dot][j]>Tval) {
							dist[t.dot][j]=Tval;
						}
					}
					pq.add(new Node(t.dot, Tval, Tcost));
				}
			}
		}
	}
	public static class Node{
		int dot;
		int val;
		int cost;
		public Node(int d, int v, int c) {
			this.dot=d;
			this.val=v;
			this.cost=c;
		}
	}
}