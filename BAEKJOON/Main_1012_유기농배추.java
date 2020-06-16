import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	public static int dx[]= {-1,1,0,0};
	public static int dy[]= {0,0,1,-1};
	public static int[][]map;
	public static boolean[][]visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;++t) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			int N=Integer.parseInt(st.nextToken());
			int ans=0;
			map=new int[M+2][N+2];
			visited=new boolean[M+2][N+2];
			int K=Integer.parseInt(st.nextToken());
			for(int i=0; i<K;++i) {
				st=new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1]=1;
			}
			for(int i=1; i<=M;++i) {
				for(int j=1; j<=N;++j) {
					if(map[i][j]==1&&visited[i][j]==false) {
						ans++;
						dfs(i,j);
					}
				}
			}
			System.out.println(ans);
		}
	}
	public static void dfs(int r, int c) {
		visited[r][c]=true;
		for(int i=0;i<4;++i) {
			int nr=r+dx[i];
			int nc=c+dy[i];
			if(map[nr][nc]==1&&visited[nr][nc]==false) {
				dfs(nr,nc);
			}
		}
	}

}
