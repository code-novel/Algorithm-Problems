import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_3307_최장증가부분수열 {
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            int N=Integer.parseInt(br.readLine());
            StringTokenizer st= new StringTokenizer(br.readLine());
            int A[]=new int[N+1];
            int dp[]=new int[N+1];
            int max=0;
            for(int i=1;i<=N;++i) {
                A[i]=Integer.parseInt(st.nextToken());
            }
            dp[0]=1;
            for(int i=2;i<=N;++i) {
                dp[i]=1;
                for(int j=1;j<=N;++j) {
                      if(A[i]>A[j]&&dp[i]<=dp[j])
                            dp[i]=dp[j]+1;
                }
                if(max<dp[i])
                    max=dp[i];
            }
            System.out.println("#"+t+" "+max);
        }
    }
}