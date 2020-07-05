import java.util.*;

public class Main_9095_123더하기 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int T;
		int dp[];
		int i;
		int n;
		n=input.nextInt();
		dp=new int[11];
		dp[0]=1;
		dp[1]=2;
		dp[2]=4;
		for(i=3;i<11;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		for (i=0;i<n;i++) {
			T=input.nextInt();
			System.out.println(dp[T-1]);
		}
	}
}