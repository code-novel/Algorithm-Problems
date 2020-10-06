import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1559_놀라운미로{
	public static int M,N,K,size, ans;
	public static int[][] map, bomul;
	public static int[] dr= {0,-1,0,1,0};	//제자리, 북, 동, 남, 서
	public static int[] dc= {0,0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			if(M==0&&N==0) break;
			map=new int[M+2][N+2];
			bomul=new int[M+2][N+2];
			for(int i=1;i<=M;++i) {
				String s = br.readLine();
				for(int j=1;j<=N;++j) {
					char tmp=s.charAt(j-1);
					if(tmp=='N') {
						map[i][j]=1;
					}else if(tmp=='E') {
						map[i][j]=2;
					}else if(tmp=='S') {
						map[i][j]=3;
					}else {
						map[i][j]=4;
					}
				}
			}
			for(int i=0;i<M+2;++i) {
				Arrays.fill(bomul[i], -1);
			}
			K=Integer.parseInt(br.readLine());
			size=(int) Math.pow(2, K);
			for(int i=0;i<K;++i) {
				st=new StringTokenizer(br.readLine());
				bomul[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=i;
			}
			bfs();
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		boolean[][][][] visited=new boolean[4][M+2][N+2][size];
		visited[3][1][1][0]=true;
		q.add(new Node(1,1,0));
		int t=0;
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int i=0;i<q_size;++i) {
				Node n=q.poll();
				if(n.r==M&&n.c==N&&n.check==size-1) {
					ans=t;
					return;
				}
				if(bomul[n.r][n.c]>=0) {
					n.check=n.check|1<<bomul[n.r][n.c];
				}
				if(!visited[t%4][n.r][n.c][n.check]) {
					visited[t%4][n.r][n.c][n.check]=true;
					q.add(new Node(n.r,n.c,n.check));
				}
				int nr=n.r+dr[map[n.r][n.c]];
				int nc=n.c+dc[map[n.r][n.c]];
				if(map[nr][nc]!=0&&!visited[t%4][nr][nc][n.check]) {
					visited[t%4][nr][nc][n.check]=true;
					q.add(new Node(nr,nc,n.check));
				}
			}
			turnMap();
			t++;
		}
	}
	public static void turnMap() {
		for(int i=1;i<=M;++i) {
			for(int j=1;j<=N;++j) {
				map[i][j]++;
				if(map[i][j]==5) {
					map[i][j]=1;
				}
			}
		}
	}
	public static class Node{
		int r;
		int c;
		int d;
		int check;
		public Node(int r, int c, int check) {
			this.r=r;
			this.c=c;
			this.check=check;
		}
	}
	public static class Bomul{
		int r;
		int c;
		public Bomul(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}