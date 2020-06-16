import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18229_내가살게아냐내가살게 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int map[][]=new int[N][M];
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int tmp[]=new int [N];
		end:
		for(int j=0;j<M;++j) {
			for(int i=0;i<N;++i) {
				tmp[i]+=map[i][j];
				if(tmp[i]>=K) {
					System.out.println((i+1)+" "+(j+1));
					break end;
				}
			}
		}
	}
}
