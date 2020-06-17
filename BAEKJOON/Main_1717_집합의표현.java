import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		parent=new int[n+1];
		make();
		for(int i=0;i<m;++i) {
			st  = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			if(a==0) {
				union(b,c);
			}else {
				if(find(b)==find(c))System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}

	public static void make() {
		Arrays.fill(parent, -1);
	}
	public static int find(int a) {
		if(parent[a]<0)return a;
		return parent[a]=find(parent[a]);
	}
	public static boolean union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
		if(rootA==rootB) return false;
		parent[rootB]=rootA;
		return true;
	}
}
