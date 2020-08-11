import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11729_하노이탑이동순서 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int n=Integer.parseInt(in.readLine());
		out.write((int)Math.pow(2,n)-1+"\n");
		Hanoi(n,1,2,3);
		out.flush();
		in.close();
		out.close();
	}
	public static void Hanoi(int n,int a, int b, int c) throws IOException {
		if(n==0) {
			return;
		}
		Hanoi(n-1, a, c, b);
		out.write(a+" "+c+"\n");
		Hanoi(n-1, b, a, c);
	}
}
