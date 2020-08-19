import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이{
	public static int K,R,C;
	public static int[][]map;
	public static boolean [][][]isVisited;
	public static int[] dx= {-1,1,0,0,-2,-2,-1,-1,1,1,2,2};
	public static int[] dy= {0,0,-1,1,-1,1,-2,2,-2,2,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		C=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[R+2][C+2];
		isVisited=new boolean[K+1][R+2][C+2];
		for(int i=0;i<R+2;++i) {
			Arrays.fill(map[i], 1);
		}
		for (int i=1;i<=R;++i) {
			st =new StringTokenizer(br.readLine());
			for(int j=1;j<=C;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {1, 1, 0});
		int time=1;
		int q_size=1;
		if(R==1&&C==1) return 0;
		while(!q.isEmpty()) {
			if(q_size==0) {q_size=q.size();time++;}
			int now[]=q.poll();
			if(now[2]<K) {
				for(int i=0;i<4;++i) {
					int nr=now[0]+dx[i];
					int nc=now[1]+dy[i];
					if(nr==R&&nc==C)return time;
					else if(map[nr][nc]==0&&!isVisited[now[2]][nr][nc]) {
						isVisited[now[2]][nr][nc]=true;
						q.add(new int[] {nr,nc,now[2]});
					}
				}
				for(int i=4;i<12;++i) {
					int nr=now[0]+dx[i];
					int nc=now[1]+dy[i];
					if(nr==R&&nc==C)return time;
					else if(nr>-1&&nc>-1&&nr<=R&&nc<=C&&map[nr][nc]==0&&!isVisited[now[2]+1][nr][nc]) {
						isVisited[now[2]+1][nr][nc]=true;
						q.add(new int[] {nr,nc,now[2]+1});
					}
				}
			}else {
				for(int i=0;i<4;++i) {
					int nr=now[0]+dx[i];
					int nc=now[1]+dy[i];
					if(nr==R&&nc==C)return time;
					else if(map[nr][nc]==0&&!isVisited[now[2]][nr][nc]) {
						isVisited[now[2]][nr][nc]=true;
						q.add(new int[] {nr,nc,now[2]});
					}
				}
			} 
			q_size--;
		}
		return -1;
	}
}