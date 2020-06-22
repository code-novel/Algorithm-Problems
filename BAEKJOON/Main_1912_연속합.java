import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_연속합{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[]= new int[N+1];
        int dp[]=new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;++i){
            num[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=N;++i){
            if(dp[i-1]+num[i]>num[i]){
                dp[i]=dp[i-1]+num[i];
            }else{
                dp[i]=num[i];
            }
        }
        int max=dp[1];
        for(int i=2;i<=N;++i){
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
	}
}