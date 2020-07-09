import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11060_점프점프 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N=Integer.parseInt(br.readLine());
	    int Dp[]=new int[1001];
	    Dp[1]=1;

	    StringTokenizer st=new StringTokenizer(br.readLine()); 
	    for(int i=1;i<=N;i++){
	        int num;
	        num=Integer.parseInt(st.nextToken());
	        if(Dp[i]==0)
	            continue;
	        for(int j=1;(j<=num) && (i+j<=1000);j++){
	            if(Dp[i+j]>Dp[i]+1 || Dp[i+j]==0)
	                Dp[i+j]=Dp[i]+1;
	        }        
	    }    
	    
	    if(Dp[N]==0)
	       System.out.println("-1");
	    else
	        System.out.println(Dp[N]-1);
	}
}