import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20205_교수님그림이깨지는데요{
	public static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int []arr=new int[N*K];
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			int idx=0;
			for(int j=0;j<N;++j) {
				int a=Integer.parseInt(st.nextToken());
				for(int k=0;k<K;++k) {
					arr[idx++]=a;
				}
			}
			for(int j=0;j<K;++j) {
				for(int k=0;k<N*K;++k) {
					sb.append(arr[k]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}