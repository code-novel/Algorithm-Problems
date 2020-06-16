import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int L=Integer.parseInt(br.readLine());
		int N=Integer.parseInt(br.readLine());
		int[]cake=new int[L+1];
		int[]cnt=new int[N+1];
		int[]P=new int[N+1];
		int[]K=new int[N+1];
		int idx=0;
		int idx2=0;
		int max=0;
		StringTokenizer st;
		for(int i=1;i<=N;++i) {
			st = new StringTokenizer(br.readLine());
			P[i]=Integer.parseInt(st.nextToken());
			K[i]=Integer.parseInt(st.nextToken());
			if(K[i]-P[i]+1>max) {max=K[i]-P[i]+1; idx2=i;}
			idx=P[i];
			while(idx<=K[i]) {
				if(cake[idx]==0)cake[idx]=i;
				idx++;
			}
		}
		System.out.println(idx2);
		for(int i=1;i<=L;++i) {
			cnt[cake[i]]++;
		}
		idx=1; max=0;
		for(int i=1;i<=N;++i) {
			if(max<cnt[i]) {
				max=cnt[i];
				idx=i;
			}
		}
        System.out.println(idx);
	}
}
