import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1{
	public static int N;
	public static int[][]zip;
	public static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		zip=new int[N+2][N+2];
		for(int i=0;i<=N+1;++i) {
			Arrays.fill(zip[i], 1);
		}
		for(int i=1;i<=N;++i) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;++j) {
				zip[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,2,0);
		System.out.println(cnt);
	}
	public static void dfs(int r, int c, int status) {
		if(r==N&&c==N) {
			cnt++;
		}else {
			if(status==0) {
				if(zip[r][c+1]==0) {
					dfs(r,c+1,status);
				}if(zip[r][c+1]==0&&zip[r+1][c+1]==0&&zip[r+1][c]==0) {
					dfs(r+1,c+1,status+2);
				}
			}else if(status==1) {
				if(zip[r+1][c]==0) {
					dfs(r+1,c,status);
				}if(zip[r][c+1]==0&&zip[r+1][c+1]==0&&zip[r+1][c]==0) {
					dfs(r+1,c+1,status+1);
				}
			}else if(status==2) {
				if(zip[r][c+1]==0&&zip[r+1][c+1]==0&&zip[r+1][c]==0) {
					dfs(r+1,c+1,status);
				}if(zip[r+1][c]==0) {
					dfs(r+1,c,status-1);
				}if(zip[r][c+1]==0) {
					dfs(r,c+1,status-2);
				}
			}
		}
	}	
}