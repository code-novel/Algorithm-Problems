import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20155_우리집밑에편의점이있는데{
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] a=new int[M+1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;++i) {
			a[Integer.parseInt(st.nextToken())]++;
		}
		int max=0;
		for(int i=1;i<=M;++i) {
			max=Math.max(max, a[i]);
		}
		System.out.println(max);
	}
}