import java.util.*;

public class Main_1463_1로만들기
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int Num=sc.nextInt();
        int dp[]=new int[1000001];
        
        dp[1]=0;
        for(int i=1;i<Num;i++) {
        	dp[i+1]=dp[i]+1;
        	if((i+1)%2==0)
        		dp[i+1]=min(dp[i+1],dp[(i+1)/2]+1);
        	if((i+1)%3==0)
        		dp[i+1]=min(dp[i+1],dp[(i+1)/3]+1);
        }
        System.out.print(dp[Num]);
    }

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		if(i>=j)
			return j;
		else 
			return i;
	}

}