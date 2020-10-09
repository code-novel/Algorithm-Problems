import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇{
	public static int M, N;
	public static int[][] map;
	public static int dr[]= {0,0,0,1,-1};	//1 : 동 2 : 서 3 : 남 4 : 북
	public static int dc[]= {0,1,-1,0,0};
	public static Node start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[M][N];
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine());
		start=new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		st=new StringTokenizer(br.readLine());
		end=new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<Node> q=new LinkedList<>();
		q.add(start);
		boolean[][][] visited=new boolean[5][M][N];
		visited[start.d][start.r][start.c]=true;
		int time=0;
		while(!q.isEmpty()) {
			//d 1:동 2:서 3:남 4:북
			int q_size=q.size();
			for(int qq=0;qq<q_size;++qq) {
				Node n=q.poll();
				if(n.r==end.r&&n.c==end.c&&n.d==end.d) return time;
				for(int i=1;i<4;++i) {
					int nr=n.r+dr[n.d]*i;
					int nc=n.c+dc[n.d]*i;
					if(nr>-1&&nc>-1&&nr<M&&nc<N) {
						if(map[nr][nc]==1)break;
						else if(!visited[n.d][nr][nc]) {
							visited[n.d][nr][nc]=true;
							q.add(new Node(nr,nc,n.d));
						}
					}
				}
				int tl=turnL(n.d);
				int tr=turnR(n.d);
				if(!visited[tl][n.r][n.c]) {
					visited[tl][n.r][n.c]=true;
					q.add(new Node(n.r,n.c,tl));
				}
				if(!visited[tr][n.r][n.c]) {
					visited[tr][n.r][n.c]=true;
					q.add(new Node(n.r,n.c,tr));
				}
			}
			time++;
		}
		return -1;
	}
	public static int turnL(int d) {
		switch(d) {
		case 1:
			return 4;
		case 2:
			return 3;
		case 3:
			return 1;
		default:
			return 2;
		}
	}
	public static int turnR(int d) {
		switch(d) {
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 2;
		default:
			return 1;
		}
	}
	public static class Node{
		int r;
		int c;
		int d;
		public Node(int r, int c, int d) {
			this.r=r;
			this.c=c;
			this.d=d;
		}
	}
}