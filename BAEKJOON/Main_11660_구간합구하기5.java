import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5{
	public static long [][]dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int [][]map = new int[N+1][N+1];
		dp= new long[N+1][N+1];
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];
			}
		}
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			System.out.println(sum(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
	}
	public static long sum(int x1, int y1, int x2, int y2) {	
		return dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
	}
}