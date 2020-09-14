import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라{
	public static int N, M, T;
	public static int[][] map;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static Sword sword;
	public static boolean getSword=false;
	public static boolean[][] isVisited;
	public static final int INF=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		isVisited=new boolean[N+2][M+2];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], 1);
		}
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int ans=bfs();
		if(getSword)
			ans=ans>(N+M-sword.r-sword.c)+sword.time?(N+M-sword.r-sword.c)+sword.time:ans;
		if(ans==INF||ans>T) System.out.println("Fail");
		else System.out.println(ans);
	}
	public static int bfs() {
		Queue<Sword> q=new LinkedList<>();
		q.add(new Sword(1,1,0));
		while(!q.isEmpty()) {
			Sword now=q.poll();
			if(now.time==T)break;
			for(int i=0;i<4;++i) {
				int nr=now.r+dx[i];
				int nc=now.c+dy[i];
				if(nr==N&&nc==M) {
					return now.time+1;
				}
				if(map[nr][nc]==0&&!isVisited[nr][nc]) {
					isVisited[nr][nc]=true;
					q.add(new Sword(nr,nc,now.time+1));
				}else if(map[nr][nc]==2&&!isVisited[nr][nc]) {
					getSword=true;
					sword=new Sword(nr,nc,now.time+1);
					isVisited[nr][nc]=true;
					q.add(sword);
				}
			}
		}
		return INF;
	}
	public static class Sword{
		int r;
		int c;
		int time;
		public Sword(int r, int c, int time) {
			this.r=r;
			this.c=c;
			this.time=time;
		}
	}
}