import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기{
	public static int N, M;
	public static int []dx= {0,0,-1,1};
	public static int []dy= {1,-1,0,0};
	public static int map[][];
	public static boolean[][][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N =Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		isVisited=new boolean[2][N+2][M+2];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], -1);
		}
		for(int i=1;i<=N;++i) {
			String s= br.readLine();
			for(int j=1;j<=M;++j) {
				map[i][j]=s.charAt(j-1)-'0';
			}
		}
		bfs();
	}
	public static void bfs() {
		int r=1;	//시작 r좌표
		int c=1;	//시작 c좌표
		int cnt=1;
		isVisited[0][r][c]=true;
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {1,1,0});
		int check=q.size();
		while(!q.isEmpty()) {
			int[] now=q.poll();
			check--;
			if(now[0]==N&&now[1]==M) {
				System.out.println(cnt);
				return;
			}else {
				for(int i=0;i<4;++i) {
					int nr=now[0]+dx[i];
					int nc=now[1]+dy[i];
					if(!isVisited[now[2]][nr][nc]) {
						if(map[nr][nc]==0) {
							q.add(new int[] {nr,nc,now[2]});
							isVisited[now[2]][nr][nc]=true;
						}
						else if(map[nr][nc]==1&&now[2]==0) {
							q.add(new int[] {nr,nc,1});
							isVisited[1][nr][nc]=true;
						}
					}
				}
			}
			if (check==0) {cnt++;check=q.size();}
		}
		System.out.println(-1);
	}
}