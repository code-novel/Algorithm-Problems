import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14502_연구소{
	public static int N,M,max;
	public static int[] dr= {-1,1,0,0};
	public static int[] dc= {0,0,-1,1};
	public static int[][] map;
	public static ArrayList<Node> virus, bean;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		virus=new ArrayList<>();
		bean=new ArrayList<>();
		map=new int[N+2][M+2];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], 1);
		}
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) bean.add(new Node(i,j));
				else if(map[i][j]==2) virus.add(new Node(i,j));
			}
		}
		for(int i=0;i<bean.size()-2;++i) {
			for(int j=i+1;j<bean.size()-1;++j) {
				for(int k=j+1;k<bean.size();++k) {
					map[bean.get(i).r][bean.get(i).c]=1;
					map[bean.get(j).r][bean.get(j).c]=1;
					map[bean.get(k).r][bean.get(k).c]=1;
					getSafe();
				}
			}
		}
		System.out.println(max);
	}
	public static void dfs(int r, int c) {
		for(int i=0;i<4;++i) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			if(map[nr][nc]==0) {
				map[nr][nc]=2;
				dfs(nr,nc);
			}
		}
	}
	public static void getSafe() {
		int cnt=0;
		for(Node n:virus) {
			dfs(n.r,n.c);
		}
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=M;++j) {
				if(map[i][j]==0)cnt++;
			}
		}
		max=Math.max(cnt, max);
		for(Node n:bean) {
			map[n.r][n.c]=0;
		}
	}
	public static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}