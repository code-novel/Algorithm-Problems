import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_8980_택배{
	public static int N, M, C, ans;
	public static int[] dosi;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(br.readLine());
		dosi=new int[N+1];
		Arrays.fill(dosi, C);
		ans=0;
		PriorityQueue<Jim> pq=new PriorityQueue<>(new Comparator<Jim>() {
			@Override
			public int compare(Jim o1, Jim o2) {
				if(o1.end==o2.end)
					return o1.start-o2.start;
				return o1.end-o2.end;
			}
		});
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			pq.add(new Jim(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		while(!pq.isEmpty()) {
			Jim tmp=pq.poll();
			if(dosi[tmp.start]==0) continue;
			int max=Integer.MAX_VALUE;
			for(int i=tmp.start;i<tmp.end;++i) {
				max=Math.min(max, dosi[i]-tmp.val>0?tmp.val:dosi[i]);
			}
			if(max==Integer.MAX_VALUE) continue;
			for(int i=tmp.start;i<tmp.end;++i) {
				dosi[i]-=max;
			}
			ans+=max;
		}
		System.out.println(ans);
	}
	public static class Jim{
		int start;
		int end;
		int val;
		
		public Jim(int s, int e, int v) {
			this.start=s;
			this.end=e;
			this.val=v;
		}
	}
}