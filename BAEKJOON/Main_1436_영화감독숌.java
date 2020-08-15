import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌{
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int num=665;
		while(N!=0) {
			if(Integer.toString(++num).contains("666"))N--;
		}
		System.out.println(num);
	}
}