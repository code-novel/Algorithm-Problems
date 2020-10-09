import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형{
	public static int N;
	public static int[][]dp;
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N][];
		for(int i=0;i<N;++i) {
			dp[i]=new int[i+1];
			StringTokenizer st=new StringTokenizer(br.readLine());
			if(i==0) {
				dp[i][0]=Integer.parseInt(st.nextToken());
				continue;
			}
			for(int j=0;j<i+1;++j) {
				int n=Integer.parseInt(st.nextToken());
				if(j==0)dp[i][j]=dp[i-1][0]+n;
				else if(j==i)dp[i][j]=dp[i-1][j-1]+n;
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-1])+n;
				}
				if(i==N-1)ans=Math.max(ans, dp[i][j]);
			}
		}
		System.out.println(ans);
	}
}