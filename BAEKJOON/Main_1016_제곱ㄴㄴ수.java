import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1016_제곱ㄴㄴ수{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long min=Long.parseLong(st.nextToken());
		long max=Long.parseLong(st.nextToken());
		boolean []isSqrt=new boolean[(int) (max-min+1)];
		for(long i=2;i<=Math.sqrt(max);++i) {
			for(long j=min/(i*i)-1;j<=max/(i*i);++j) {	
				long tmp=i*i*j;
				if(tmp>=min) {
					isSqrt[(int)(tmp-min)]=true;
				}
			}
		}
		int cnt=0;
		for(int i=0;i<isSqrt.length;++i) {
			if(!isSqrt[i])cnt++;
		}
		System.out.println(cnt);
	}
}