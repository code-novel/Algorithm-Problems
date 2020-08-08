import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	public static int[] day;
	public static int[] price;
	public static int N;
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		day=new int [N+1];
		price=new int [N+1];
		max=0;
		StringTokenizer st;
		for(int i=1; i<=N; ++i) {
			st=new StringTokenizer(br.readLine());
			day[i]=Integer.parseInt(st.nextToken());
			price[i]=Integer.parseInt(st.nextToken());
		}
		boolean []selected=new boolean[N+1];
		work(1,selected);
		System.out.println(max);
	}
	public static void work(int now, boolean []selected) {
		if(now==N+1) {
			int money=0;
			for(int i=1;i<=N;++i) {
				if(selected[i]) {
					money+=price[i];
				}
			}
			max=max<money?money:max;
			return;
		}else {
			work(now+1,selected);
			int j=now+day[now];
			if(j<=N+1) {
				selected[now]=true;
				work(j,selected);
				selected[now]=false;
			}
			
		}
	}
}
