import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1113_수영장만들기 {
	public static int N,M;
	public static int[][]map;
	public static int[] dx= {0,0,-1,1};
	public static int[] dy= {-1,1,0,0};
	public static boolean[][] isVisited;
	public static int[][] preMap;
	public static int ans=0;
	public static int max_height=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int [N+2][M+2];
		for (int i=1;i<=N;++i) {
			String s=br.readLine();
			for(int j=1;j<=M;++j) {
				map[i][j]=s.charAt(j-1)-'0';
				max_height=Math.max(map[i][j], max_height);
			}
		}
		for(int i=max_height;i>1;--i) {
			preMap=new int[N+2][M+2];
			isVisited=new boolean[N+2][M+2];
			LinkedList<int[]> tmp= new LinkedList<>();
			for(int j=1;j<=N;++j) {
				for(int k=1;k<=M;++k) {
					if(map[j][k]>=i) {
						preMap[j][k]=1;
					}else {
						preMap[j][k]=0;
					}
				}
			}
			for(int j=0;j<=N+1;++j) {
				for(int k=0;k<=M+1;++k) {
					if(preMap[j][k]==0&&!isVisited[j][k]) {
						tmp.add(new int[] {j,k});
						dfs(j,k);
					}
				}
			}
			if(tmp.size()==1)continue;
			else {
				isVisited=new boolean[N+2][M+2];
				for(int j=1;j<tmp.size();++j) {
					calc(tmp.get(j)[0],tmp.get(j)[1]);
				}
			}
		}
		System.out.println(ans);
	}
	public static void calc(int r,int c) {
		isVisited[r][c]=true;
		ans++;
		for(int i=0;i<4;++i) {
			int nr=r+dx[i];
			int nc=c+dy[i];
			if(preMap[nr][nc]==0&&!isVisited[nr][nc]) {
				calc(nr,nc);
			}
		}
	}
	public static void dfs(int r, int c) {
		isVisited[r][c]=true;
		for(int i=0;i<4;++i) {
			int nr=r+dx[i];
			int nc=c+dy[i];
			if(nr>-1&&nc>-1&&nr<N+2&&nc<M+2&&preMap[nr][nc]==0&&!isVisited[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}
}
