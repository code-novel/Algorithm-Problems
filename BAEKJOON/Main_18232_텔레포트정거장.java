import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18232_텔레포트정거장 {
	public static int N, M, S, E;
	public static ArrayList<Integer> map[];
	public static boolean isVisited[];
	public static int min=300001;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new ArrayList[N+1];
		for(int i=0;i<N+1;++i) {
			map[i] = new ArrayList<Integer>();
		}
		isVisited=new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		for (int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		bfs();
		System.out.println(min);
	}
	public static void bfs() {
		Queue<Integer> q =new LinkedList<Integer>();
		q.add(S);
		isVisited[S]=true;
		int q_size=q.size();
		int level=1;
		out:
		while(true) {
			if(q_size==0) {q_size=q.size(); level++;};
			int now=q.poll();
			for(int i=0;i<map[now].size();++i) {
				int go=map[now].get(i);
				if(go==E){min=level;break out;}
				else if(!isVisited[go]) {
					q.add(go);
					isVisited[go]=true;
				}
			}
			if(now>1) {
				if(now-1==E) {min=level;break;}
				else if(!isVisited[now-1]) {q.add(now-1);isVisited[now-1]=true;}
			}
			if(now<N) {
				if(now+1==E) {min=level;break;}
				else if(!isVisited[now+1]) {q.add(now+1);isVisited[now+1]=true;}
			}
			q_size--;
		}
	}

}
