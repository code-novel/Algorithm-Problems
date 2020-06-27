import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치{
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []key=new int[N];
		int []weight= new int [N];
		StringTokenizer st;
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			key[i]=Integer.parseInt(st.nextToken());
			weight[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;++i) {
			int cnt=1;
			for(int j=0;j<N;++j) {
				if(key[i]<key[j]&&weight[i]<weight[j]) {
					cnt++;
				}
			}
			System.out.print(cnt+" ");
		}
	}
}
