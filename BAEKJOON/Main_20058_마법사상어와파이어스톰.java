import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058_마법사상어와파이어스톰{
	public static int N, Q;
	public static int map[][];
	public static int len;
	public static int dr[]= {-1,1,0,0};
	public static int dc[]= {0,0,-1,1};
	public static int max, num;
	public static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		len=(int) Math.pow(2, N);
		map=new int[len][len];
		for(int i=0;i<len;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<len;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<Q;++i) {
			int q=Integer.parseInt(st.nextToken());
			fireStorm(0,len,0,len,0,N-q);
			melting();
		}
		getAnswer();
		System.out.println(num);
		System.out.println(max);
	}
	public static void bfs(int r, int c) {
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(r,c));
		int cnt=0;
		while(!q.isEmpty()) {
			Node n=q.poll();
			cnt++;
			num+=map[n.r][n.c];
			for(int i=0;i<4;++i) {
				int nr=n.r+dr[i];
				int nc=n.c+dc[i];
				if(nr>-1&&nc>-1&&nr<len&&nc<len&&map[nr][nc]!=0&&!visited[nr][nc]) {
					visited[nr][nc]=true;
					q.add(new Node(nr,nc));
				}
			}
		}
		max=Math.max(cnt, max);
	}
	public static void getAnswer() {
		max=0;
		num=0;
		visited=new boolean[len][len];
		for(int i=0;i<len;++i) {
			for(int j=0;j<len;++j) {
				if(map[i][j]!=0&&!visited[i][j]) {
					visited[i][j]=true;
					bfs(i,j);
				}
			}
		}
	}
	public static void melting() {
		boolean[][] melt=new boolean[len][len];
		for(int i=0;i<len;++i) {
			for(int j=0;j<len;++j) {
				if(map[i][j]==0) continue;
				int time=0;
				for(int k=0;k<4;k++) {
					int ni=i+dr[k];
					int nj=j+dc[k];
					if(ni>-1&&nj>-1&&ni<len&&nj<len&&map[ni][nj]!=0) {
						time++;
					}
				}
				if(time<3) {
					melt[i][j]=true;
				}
			}
		}
		for(int i=0;i<len;++i) {
			for(int j=0;j<len;++j) {
				if(melt[i][j])map[i][j]--;
			}
		}
	}
	public static void fireStorm(int sr, int er, int sc, int ec, int now, int q) {
		int mr=(sr+er)/2;
		int mc=(sc+ec)/2;
		if(now==q) {
			int idx=er-sr;
			int[][] tmpMap=new int[idx][idx];
			for(int i=0;i<idx;++i) {
				for(int j=0;j<idx;++j) {
					tmpMap[j][idx-1-i]=map[sr+i][sc+j];
				}
			}
			for(int i=0;i<idx;++i) {
				for(int j=0;j<idx;++j) {
					map[sr+i][sc+j]=tmpMap[i][j];
				}
			}
		}else {
			fireStorm(sr,mr,sc,mc,now+1,q);
			fireStorm(sr,mr,mc,ec,now+1,q);
			fireStorm(mr,er,sc,mc,now+1,q);
			fireStorm(mr,er,mc,ec,now+1,q);
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