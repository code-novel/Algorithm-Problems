import java.util.Scanner;

public class Main_1149_RGB거리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		int N=sc.nextInt();
		int[][]map=new int[N][3];
		for(int i=0;i<N;i++) {
			map[i][0]=sc.nextInt();
			map[i][1]=sc.nextInt();
			map[i][2]=sc.nextInt();
		}
		int []dp=new int [3];
		int []temp=new int [3];
		dp[0]=map[1][0]+min(map[0][1],map[0][2]);
		dp[1]=map[1][1]+min(map[0][0],map[0][2]);
		dp[2]=map[1][2]+min(map[0][0],map[0][1]);
		for(int i=2;i<N;++i) {
			temp[0]=dp[0];
			temp[1]=dp[1];
			temp[2]=dp[2];
			dp[0]=map[i][0]+min(temp[1],temp[2]);
			dp[1]=map[i][1]+min(temp[0],temp[2]);
			dp[2]=map[i][2]+min(temp[0],temp[1]);
		}
		System.out.println(min(dp[0],min(dp[1],dp[2])));
	}

	public static int min(int a, int b) {
		return a>b?b:a;
	}
}
