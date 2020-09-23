import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16724_피리부는사나이{
	public static int R,C;
	public static int[][] map, check;
	public static boolean[][] isVisited;
	public static int[]dx= {-1,1,0,0};
	public static int[]dy= {0,0,-1,1};
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new int [R+2][C+2];
		check=new int[R+2][C+2];
		isVisited=new boolean[R+2][C+2];
		for(int i=0;i<R+2;++i) {
			Arrays.fill(map[i], -1);
		}
		for(int i=1;i<=R;++i) {
			String s=br.readLine();
			for(int j=1;j<=C;++j) {
				char tmp=s.charAt(j-1);
				if(tmp=='U') {
					map[i][j]=0;
				}else if(tmp=='D') {
					map[i][j]=1;
				}else if(tmp=='L') {
					map[i][j]=2;
				}else {
					map[i][j]=3;
				}
			}
		}
		for(int i=1;i<=R;++i) {
			for(int j=1;j<=C;++j) {
				if(!isVisited[i][j]) {
					ans++;
					isVisited[i][j]=true;
					check[i][j]=ans;
					dfs(i,j);
				}
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int r, int c) {
		for(int i=0;i<4;++i) {
			int nr=r+dx[i];
			int nc=c+dy[i];
			if(!isVisited[nr][nc]&&map[nr][nc]!=-1) {
				if(nr+dx[map[nr][nc]]==r&&nc+dy[map[nr][nc]]==c) {
					isVisited[nr][nc]=true;
					check[nr][nc]=ans;
					dfs(nr,nc);
				}else if(r+dx[map[r][c]]==nr&&c+dy[map[r][c]]==nc) {
					isVisited[nr][nc]=true;
					check[nr][nc]=ans;
					dfs(nr,nc);
				}
			}
		}
	}
}