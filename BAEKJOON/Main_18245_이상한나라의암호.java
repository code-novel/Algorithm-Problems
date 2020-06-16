import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main_18245_이상한나라의암호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int j=2;
		while(true) {
			String s=br.readLine();
			if(s.equals("Was it a cat I saw?"))break;
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<s.length();i+=j) {
				sb.append(s.charAt(i));
			}
			System.out.println(sb);
			j++;
		}
	}
}