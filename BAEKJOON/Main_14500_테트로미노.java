import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노{
	public static int N, M;
	public static int[][]map;
	public static int max=0;
	public static int[] dx= {0,0,-1,1};
	public static int[] dy= {-1,1,0,0};
	public static boolean[][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		isVisited=new boolean[N+2][M+2];
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=M;++j) {
				isVisited[i][j]=true;
				dfs(i,j,0,map[i][j]);
				isVisited[i][j]=false;
				cross(i,j);
			}
		}
		System.out.println(max);
	}
	public static void cross(int r, int c) {
		for(int i=0;i<4;++i) {
			int score=map[r][c];
			for(int j=0;j<4;++j) {
				if(j==i)continue;
				int nr=r+dx[j];
				int nc=c+dy[j];
				if(map[nr][nc]==0)break;
				score+=map[nr][nc];
			}
			max=Math.max(max, score);
		}
	}
	public static void dfs(int r, int c,int idx,int score) {
		if(idx==3) {
			max=Math.max(max, score);
			return;
		}else {
			for(int i=0;i<4;++i) {
				int nr=r+dx[i];
				int nc=c+dy[i];
				if(map[nr][nc]>0&&!isVisited[nr][nc]) {
					isVisited[nr][nc]=true;
					dfs(nr,nc,idx+1,score+map[nr][nc]);
					isVisited[nr][nc]=false;
				}
			}
		}
	}
}