import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13199_치킨먹고싶다{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;++tc) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int P=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int F=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			int s=0;
			int s_coupon=((M/P)*C)/F*C+((M/P)*C)%F;
			if(s_coupon-F>=0) s=(s_coupon-F)/(F-C)+1;
			sb.append(s+"\n");
		}
		System.out.println(sb.toString());
	}
}