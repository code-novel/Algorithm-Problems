import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_17388_와글와글숭고한{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int S=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		if(S+K+H>99)System.out.println("OK");
		else {
			System.out.println(min(S,K,H));
		}
	}
	
	public static String min(int s, int k, int h) {
		if(s<k&&s<h) {
			return "Soongsil";
		}else if(k<s&&k<h) {
			return "Korea";
		}else {
			return "Hanyang";
		}
	}
}