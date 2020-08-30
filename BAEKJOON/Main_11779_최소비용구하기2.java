import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11779_최소비용구하기2{
	public static int N, M;
	public static ArrayList<Node> []list;
	public static ArrayList<Integer> ans=new ArrayList<>();
	public static int start, end;
	public static int[] d;
	public static int[] path;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		list=new ArrayList[N+1];
		d=new int[N+1];
		path=new int[N+1];
		visited=new boolean[N+1];
		for(int i=1;i<N+1;++i) {
			list[i]=new ArrayList<>();
			d[i]=Integer.MAX_VALUE;
		}
		StringTokenizer st;
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			int j=Integer.parseInt(st.nextToken());
			list[j].add( new Node( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		st=new StringTokenizer(br.readLine());
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		dijkstra();
		System.out.println(d[end]);
		ans.add(end);
		int cnt=1;
		while(true) {
			int k=path[end];
			if(k==0) break;
			ans.add(k);
			end=k;
			cnt++;
		}
		System.out.println(cnt);
		for(int i=ans.size()-1;i>-1;--i) {
			System.out.print(ans.get(i)+" ");
		}
	}
	public static void dijkstra() {
		PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.v-o2.v;
			}
		});
		d[start]=0;
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node n=pq.poll();
			if(visited[n.d])continue;
			visited[n.d]=true;
			for(int i=0;i<list[n.d].size();++i) {
				int now=list[n.d].get(i).d;
				int dis=list[n.d].get(i).v;
				if(d[n.d]+dis<d[now]) {
					d[now]=d[n.d]+dis;
					path[now]=n.d;
					pq.add(new Node(now,d[now]));
				}
			}
		}
	}
	public static class Node{
		int d;
		int v;
		public Node(int d, int v) {
			this.d=d;
			this.v=v;
		}
	}
}
