import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥{
	public static int N, d, k, c;
	public static int max=0;
	public static int now=0;
	public static int []chobab;
	public static int []table;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		chobab=new int[d+1];
		table=new int[N+k-1];
		for(int i=0;i<N;++i) {
			table[i]=Integer.parseInt(br.readLine());
		}
		for(int i=N;i<table.length;++i) {
			table[i]=table[i-N];
		}
		chobab[c]++;
		now++;
		for(int i=0;i<k;++i) {
			if(chobab[table[i]]==0) {
				now++;
			}
			chobab[table[i]]++;
		}
		max=now;
		int start=0;
		int end=k;
		for(int i=1;i<N;++i) {
			chobab[table[start]]--;
			if(chobab[table[start]]==0) now--;
			chobab[table[end]]++;
			if(chobab[table[end]]==1) now++;
			max=Math.max(now, max);
			start++;
			end++;
		}
		System.out.println(max);
	}
}