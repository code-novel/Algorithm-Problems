import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {
	public static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int room[] = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		dp = new int[N+1][N+1];
		Arrays.fill(dp[0], 1);
		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= N - i + 1; j++) {
				if (room[j] == room[j+i-1] && dp[i-2][j+1] == 1)
					dp[i][j] = 1;
			}
		}
		for(int i=0; i<M;++i) {
			st = new StringTokenizer(br.readLine());
			int S, E;
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			sb.append(dp[E-S+1][S]+"\n");
		}
		System.out.println(sb.toString());
	}
}
