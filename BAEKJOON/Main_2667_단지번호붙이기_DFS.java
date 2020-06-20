import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_2667_단지번호붙이기_DFS {
	public static int dx[]= {-1,1,0,0};
	public static int dy[]= {0,0,1,-1};
	public static int[][]map;
	public static boolean[][]visited;
	public static int tmp;
	public static List<Integer> danji=new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N=Integer.parseInt(br.readLine());
		map=new int[N+2][N+2];
		visited=new boolean[N+2][N+2];
		int d=0;
		for(int i=1;i<=N;++i) {
			String str = br.readLine();
			for(int j=1; j<=N;++j) {
				map[i][j]=(int)str.charAt(j-1)-48;
			}
		}
		for(int i=1;i<=N;++i) {
			for(int j=1; j<=N;++j) {
				if(map[i][j]==1&&visited[i][j]==false) {
					tmp=1;
					d++;
					dfs(i,j);
					danji.add(tmp);
				}
			}
		}
		danji.sort(null);
		System.out.println(danji.size());
		for(int dj : danji)
			System.out.println(dj);
	}
	public static void dfs(int i, int j) {
		visited[i][j]=true;
		for(int d=0; d<4;++d) {
			int ni=i+dx[d];
			int nj=j+dy[d];
			if(map[ni][nj]==1&&visited[ni][nj]==false) {
				tmp++;
				dfs(ni,nj);
			}
		}
	}
}