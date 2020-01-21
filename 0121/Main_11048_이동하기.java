import java.util.Scanner;
public class Main_11048_이동하기 {
	static int candymap[][];
	static int dp[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		candymap=new int[N+1][M+1];
		dp=new int[N+1][M+1];
		for(int i =1; i<=N; ++i) {
			for(int j=1; j<=M;++j) {
				candymap[i][j]=sc.nextInt();
			}
		}
		for(int i=1; i<=N;++i) {
			for(int j=1; j<=M; ++j) {
				int res =0;
				res =max(dp[i-1][j-1],max(dp[i-1][j], dp[i][j-1]));
				dp[i][j] = res + candymap[i][j];
			}
		}
		System.out.println(dp[N][M]);
	}
	public static int max(int a, int b) {
		return a>b?a:b;
	}
}