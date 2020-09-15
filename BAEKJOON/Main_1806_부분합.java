import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {
	public static int N, S;
	public static int ans=Integer.MAX_VALUE;
	public static int []arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;++i) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int sum=arr[0];
		int end=0;
		for(int start=0;start<N;++start) {
			while(sum<S&&end<N-1) {
				end++;
				sum+=arr[end];
			}
			if(sum>=S)
				ans=Math.min(ans, end-start+1);
			sum-=arr[start];
		}
		if(ans==Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(ans);
	}
}