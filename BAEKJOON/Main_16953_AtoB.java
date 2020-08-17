import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953_AtoB{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int cnt=1;
		while(N<M) {
			if(M%2==0) {
				M=M/2;
				cnt++;
			}else if(M%10==1) {
				M=M/10;
				cnt++;
			}else {
				break;
			}
		}
		if(N==M)System.out.println(cnt);
		else System.out.println(-1);
	}
}