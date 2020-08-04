import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main_11724_연결요소의개수 {
	public static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		parent=new int[N+1];
		fill();
		int cnt=0;
		for(int i=0;i<M;++i) {
			st= new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			union(a,b);
		}
		for(int i=1;i<=N;++i) {
			if(parent[i]==-1)cnt++;
		}
		System.out.println(cnt);
	}
	public static void fill() {
		Arrays.fill(parent, -1);
	}
	public static int find(int a) {
		if(parent[a]==-1)return a;
		else
			return find(parent[a]);
	}
	public static boolean union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
		if(rootA==rootB)return false;
		else {
			parent[rootA]=rootB;
			return true;
		} 
	}
}
