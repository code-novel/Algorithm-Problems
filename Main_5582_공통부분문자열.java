import java.util.Scanner;

public class Main_5582_공통부분문자열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int dp[][] = new int[4001][4001];
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		for (int i = 0; i<s1.length(); i++) {
			for (int j = 0; j<s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i == 0 || j == 0)
						dp[i][j] = 1;
					else
						dp[i][j] = dp[i - 1][j - 1] + 1;

					if (max < dp[i][j])
						max = dp[i][j];
				}
			}
		}
		System.out.println(max);
	}
}
