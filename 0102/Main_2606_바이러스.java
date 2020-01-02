import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	public static int[] parent;
    public static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		parent = new int[N+1];
		 for(int i = 1; i <= N; i++) {
	            parent[i] = i;
	        }
	        for(int i = 1; i <= M; i++) {
	        	StringTokenizer st=new StringTokenizer(br.readLine());
	            int x = Integer.parseInt(st.nextToken());
	            int y = Integer.parseInt(st.nextToken());
	            union(x,y);
	        }
			
	        int cnt = 0;
	        for(int i = 2; i <= N; i++) {
	            if(find(i)== find(1))
	                ++cnt;
	        }
	        System.out.println(cnt);
	}

}
