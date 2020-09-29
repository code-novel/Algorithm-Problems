import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11967_불켜기{
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static ArrayList<Node>[][] list;
	public static int N, M;
	public static int ans=1;
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new boolean[N+2][N+2];
		list=new ArrayList[N+2][N+2];
		map[1][1]=true;
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=N;++j) {
				list[i][j]=new ArrayList<>();
			}
		}
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			list[a][b].add(new Node(c,d));
		}
		bfs();
		System.out.println(ans);
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		boolean[][][] isVisited=new boolean[N+2][N+2][N*N+1];
		isVisited[1][1][1]=true;
		q.add(new Node(1,1));
		while(!q.isEmpty()) {
			Node n=q.poll();
			for(int i=0;i<list[n.r][n.c].size();++i) {
				if(!map[list[n.r][n.c].get(i).r][list[n.r][n.c].get(i).c]) {
					map[list[n.r][n.c].get(i).r][list[n.r][n.c].get(i).c]=true;
					ans++;
				}
			}
			for(int i=0;i<4;++i) {
				int nr=n.r+dx[i];
				int nc=n.c+dy[i];
				if(map[nr][nc]&&!isVisited[nr][nc][ans]) {
					isVisited[nr][nc][ans]=true;
					q.add(new Node(nr,nc));
				}
			}
		}
	}
	public static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}