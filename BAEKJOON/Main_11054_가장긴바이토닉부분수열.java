import java.util.Scanner;

public class Main_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[][] = new int[2][N + 1];
		int A[] = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; ++i) {
			A[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			int maxA = 0;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					if (maxA < dp[0][j])
						maxA = dp[0][j];
				}
			}
			dp[0][i] = maxA + 1;
		}
		for (int i = N; i >= 1; i--)
	    {
	        int maxA = 0;
	        for (int j = N; j > i; j--){
	            if (A[i]>A[j]){
	                if (maxA < dp[1][j])
	                    maxA = dp[1][j];
	            }
	        }
	        if (dp[1][i]<maxA + 1)
	            dp[1][i] = maxA + 1;
	    }
	    
	    for (int i = 1; i <= N; i++){
	        if (max < dp[0][i] + dp[1][i])
	            max = dp[0][i] + dp[1][i];
	    }
	 
	 
	    System.out.println(max-1);
	}

}