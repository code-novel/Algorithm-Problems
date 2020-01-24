import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958_동전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;++t) {
			int oo=0;
			int ans=0;
			String s=br.readLine();
			for(int i=0; i<s.length();++i) {
				if(s.charAt(i)=='O') {
					oo++;
					ans+=oo;
				}else {
					oo=0;
				}
			}
			System.out.println(ans);
		}
	}
}