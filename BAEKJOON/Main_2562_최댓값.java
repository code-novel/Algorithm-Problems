import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562_최댓값{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int a[]=new int[9];
		for(int i=0;i<9;++i) {
			a[i]=Integer.parseInt(br.readLine());
		}
		int max=0;
		int idx=-1;
		for(int i=0;i<9;++i) {
			if(max<a[i]) {
				max=a[i];
				idx=i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}