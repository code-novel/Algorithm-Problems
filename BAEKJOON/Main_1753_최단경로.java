import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로{
	public static class Node{
		int dot;
		int val;
		public Node(int d, int v){
			this.dot=d;
			this.val=v;
		}
	}
	public static int V, E, K;
	public static final int INF=Integer.MAX_VALUE;
	public static ArrayList<Node> []list;
	public static int[] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine());
		list=new ArrayList[V+1];
		d=new int[V+1];
		for(int i=0;i<V+1;++i) {
			list[i]=new ArrayList<>();
		}
		Arrays.fill(d, INF);
		d[K]=0;
		for(int i=0;i<E;++i) {
			st=new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		dijkstra();
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<V+1;++i) {
			if(d[i]==INF)
				sb.append("INF\n");
			else
				sb.append(d[i]+"\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
	public static void dijkstra() {
		PriorityQueue<Node> pq= new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.val==o2.val)
					return o1.dot-o2.dot;
				return o1.val-o2.val;
			}
		});
		pq.add(new Node (K,0));
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			if(d[tmp.dot]<tmp.val)continue;
			for(int i=0;i<list[tmp.dot].size();++i) {
				Node l=list[tmp.dot].get(i);
				if(d[tmp.dot]+l.val<d[l.dot]) {
					d[l.dot]=d[tmp.dot]+l.val;
					pq.add(new Node(l.dot, d[l.dot]));
				}
			}
		}
	}
}