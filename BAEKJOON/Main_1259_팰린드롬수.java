import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String num=br.readLine();
		while(!num.equals("0")) {
			boolean mirror=true;
			int len=num.length();
			for(int i=0;i<len/2;++i) {
				if(num.charAt(i)!=num.charAt(len-i-1)) {
					mirror=false;
				}
			}
			if(mirror) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			num=br.readLine();
		}
	}
}