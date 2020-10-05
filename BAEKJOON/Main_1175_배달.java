import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1175_배달{
	public static int N, M;
	public static int [][] map;
	public static Node S, C1, C2;
	public static int dr[]= {0,-1,1,0,0};
	public static int dc[]= {0,0,0,-1,1};
	public static int ans=-1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		boolean flag=false;
		for(int i=1;i<=N;++i) {
			String s=br.readLine();
			for(int j=1;j<=M;++j) {
				if(s.charAt(j-1)=='S') {	//0는 #, 1은 . , 2는 C 
					S=new Node(i,j,0,3,0);
					map[i][j]=1;
				}else if(s.charAt(j-1)=='C'){
					if(!flag) {
						C1=new Node(i,j,0,3,0);
						flag=true;
					}else {
						C2=new Node(i,j,0,3,0);
					}
					map[i][j]=1;
				}else if(s.charAt(j-1)=='#') {
					map[i][j]=0;
				}else {
					map[i][j]=1;
				}
			}
		}
		bfs();
		System.out.println(ans);
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		boolean[][][][] visited=new boolean[N+2][M+2][5][4];
		q.add(S);
		visited[S.r][S.c][0][2]=true;
		while(!q.isEmpty()) {
			Node n=q.poll();
			if(n.state!=2&&n.r==C1.r&&n.c==C1.c) {
				n.state--;
				visited[n.r][n.c][n.d][n.state]=true;
			}else if(n.state!=1&&n.r==C2.r&&n.c==C2.c) {
				n.state-=2;
				visited[n.r][n.c][n.d][n.state]=true;
			}
			if(n.state==0) {ans=n.time; return;}
			for(int i=1;i<5;++i) {
				if(i==n.d)continue;
				int nr=n.r+dr[i];
				int nc=n.c+dc[i];
				if(map[nr][nc]==1&&!visited[nr][nc][i][n.state]) {
					visited[nr][nc][i][n.state]=true;
					q.add(new Node(nr,nc,i,n.state,n.time+1));
				}
			}
		}
	}
	public static class Node{
		int r;
		int c;
		int d;
		int state;
		int time;
		public Node(int r, int c, int d,int state, int time) {
			this.r=r;
			this.c=c;
			this.d=d;
			this.state=state;
			this.time=time;
		}
	}
}