import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17069_파이프옮기기2 {
	public static int N;
	public static int map[][];
	public static long dp[][][];	//0은 가로 상태, 1은 대각선 상태, 2는 세로 상태.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		dp=new long[3][N][N];
		StringTokenizer st;
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<N;++i) {
			if(map[0][i]==0)
				dp[0][0][i]=1;
			else break;
		}
		for(int i=1;i<N;++i) {
			for(int j=2;j<N;++j) {
				if(map[i][j]==0) {
					dp[0][i][j]=dp[0][i][j-1]+dp[1][i][j-1];
					if(map[i-1][j]==0&&map[i][j-1]==0) dp[1][i][j]=dp[0][i-1][j-1]+dp[1][i-1][j-1]+dp[2][i-1][j-1];
					dp[2][i][j]=dp[1][i-1][j]+dp[2][i-1][j];
				}
			}
		}
		System.out.println(dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1]);
	}
}