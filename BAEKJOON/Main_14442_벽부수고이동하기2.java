import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2{
	public static int N, M, K;
	public static int[][] map;
	public static final int INF=Integer.MAX_VALUE;
	public static int ans=INF;
	public static int[] dr= {-1,1,0,0};
	public static int[] dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], 2);
		}
		for(int i=1;i<=N;++i) {
			String s=br.readLine();
			for(int j=1;j<=M;++j) {
				map[i][j]=s.charAt(j-1)-'0';
			}
		}
		bfs();
		if(ans==INF) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		boolean[][][] visited=new boolean[N+2][M+2][K+1];
		q.add(new Node(1,1,0));
		visited[1][1][0]=true;
		int lv=1;
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int p=0;p<q_size;++p) {
				Node n=q.poll();
				if(n.r==N&&n.c==M) {
					ans=Math.min(ans, lv);
					return;
				}
				for(int i=0;i<4;++i) {
					int nr=n.r+dr[i];
					int nc=n.c+dc[i];
					if(!visited[nr][nc][n.k]) {
						if(map[nr][nc]==0) {
							visited[nr][nc][n.k]=true;
							q.add(new Node(nr,nc,n.k));
						}else if(n.k<K&&map[nr][nc]==1) {
							visited[nr][nc][n.k+1]=true;
							q.add(new Node(nr,nc,n.k+1));
						}
					}
				}
			}
			lv++;
		}
	}
	
	public static class Node{
		int r;
		int c;
		int k;
		public Node(int r, int c, int k) {
			this.r=r;
			this.c=c;
			this.k=k;
		}
	}
}