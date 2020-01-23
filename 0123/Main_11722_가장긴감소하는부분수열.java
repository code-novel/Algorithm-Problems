import java.util.Scanner;
public class Main_11722_가장긴감소하는부분수열 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[]=new int [N+1];
		int A[] = new int [N+1];
		int max=0;
		for(int i=1; i<=N;++i) {
			A[i]=sc.nextInt();
		}
		for(int i=1; i<=N; ++i) {
			int min=0;
			for(int j=0; j<i;j++) {
				if(A[i]<A[j]) {
					if(min < dp[j])
						min = dp[j];
				}
			}
			dp[i]=min+1;
			if(max < dp[i])
				max=dp[i];
		}
		System.out.println(max);
	}
}