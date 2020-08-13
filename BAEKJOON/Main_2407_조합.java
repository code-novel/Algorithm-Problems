import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407_조합{
	public static BigInteger[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		dp=new BigInteger [N+1][M+1];
		System.out.println(combi(N,M).toString());
	}
	private static BigInteger combi(int n, int m) {
		if (n == m || m == 0) return BigInteger.valueOf(1);
		if (dp[n][m] != null) return dp[n][m];
		dp[n][m] = new BigInteger("0");
		return dp[n][m]=dp[n][m].add(combi(n - 1, m - 1)).add(combi(n - 1, m));
		}
}