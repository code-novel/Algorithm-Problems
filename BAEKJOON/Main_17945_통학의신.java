import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17945_통학의신 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		if(A*A-B==0) {
			System.out.println(-1*A);
		}else {
			System.out.print(-1*A-(int)Math.sqrt(A*A-B)+" "+(A*(-1)+(int)Math.sqrt(A*A-B)));
		}
	}
}
