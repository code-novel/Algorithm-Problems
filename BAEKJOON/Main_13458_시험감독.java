import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[]A=new int[N];
		for(int i=0;i<N;++i) {
			A[(int) i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		long cnt=0;
		for(int i=0;i<N;++i) {
			cnt++;
			A[(int) i]-=B+1;
			if(A[(int) i]+1>0)
				cnt+=A[(int) i]/C+1;
		}
		System.out.println(cnt);
	}
}
