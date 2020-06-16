import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int V=Integer.parseInt(st.nextToken());	//정점의 개수
		int E=Integer.parseInt(st.nextToken());	//간선의 개수
		boolean[] visited=new boolean[V+1];
		int []len=new int[V+1];
		long ans=0;
		Arrays.fill(len, 1000001);		//초기화
		ArrayList<int[]>[] map =new ArrayList[V+1];
		for(int i=1;i<V+1;i++) {
			map[i]=new ArrayList<>();
		}
		for(int i=0;i<E;++i) {
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			int C=Integer.parseInt(st.nextToken());
			int[] tmp=new int[] {B,C};
			int[] tmp2=new int[] {A,C};
			map[A].add(tmp);
			map[B].add(tmp2);
		}
		int idx=0;
		len[1]=0;
		while(idx<V) {
			int min=1000001;
			int u=-1;
			for(int i=1;i<V+1;++i) {		//작은 값을 선택 후 다른 정점으로!
				if(!visited[i]&&len[i]<min) {
					min=len[i];
					u=i;
				}
			}
			for(int i=1;i<V+1;++i) {		//u에서 i까지 거리를 통해 len을 바꿔줌
				if(!visited[i]) {
					for(int j=0;j<map[u].size();++j) {
						if(map[u].get(j)[0]==i) {
							len[i]=Math.min(len[i], map[u].get(j)[1]);
						}
					}
				}
			}
			idx++;
			ans+=min;
			visited[u]=true;
		}
		System.out.println(ans);
	}
}
