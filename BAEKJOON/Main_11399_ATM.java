import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int ans=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int []arr=new int[N+1];
		for(int i=1;i<=N;++i) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=1;i<=N;++i)
			ans+=arr[i]*(N-i+1);
        System.out.println(ans);
	}
}