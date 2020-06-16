import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int cnt=99;
		if(N==1000) N-=1;
		if(N<100)System.out.println(N);
		else {
			for(int i=100;i<=N;++i) {
				if (((i / 10 % 10) - (i / 100)) == ((i % 10) - (i / 10 % 10)))cnt++;
			}
            System.out.println(cnt);
		}
	}
}
