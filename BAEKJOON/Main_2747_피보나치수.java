import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		int T;
		int dp[];
		int i=2;
		T=input.nextInt();
		dp=new int[T+1];
		dp[0]=0;
		dp[1]=1;
		for(i=2;i<T+1;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.print(dp[T]);
	}
}