import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2623_음악프로그램{
	public static int N, M;
	public static int[] idol;
	public static LinkedList<Integer>[] list;
	public static Queue<Integer> q=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		list=new LinkedList[N+1];
		idol=new int[N+1];
		for(int i=1;i<N+1;++i) {
			list[i]=new LinkedList<>();
		}
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			st.nextToken();
			int start=Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int next=Integer.parseInt(st.nextToken());
				list[start].add(next);
				idol[next]++;
				start=next;
			}
		}
		for(int i=1;i<=N;++i) {
			if(idol[i]==0) q.add(i);
		}
		boolean fail=false;
		for(int i=1;i<=N;++i) {
			if(q.isEmpty()) {fail=true;break;}
			int num=q.poll();
			sb.append(num+"\n");
			for(int j=0;j<list[num].size();++j) {
				idol[list[num].get(j)]--;
				if(idol[list[num].get(j)]==0) q.add(list[num].get(j));
			}
		}
		if(fail) {
			System.out.println(0);
		}else {
			System.out.println(sb.toString());
		}
	}
}