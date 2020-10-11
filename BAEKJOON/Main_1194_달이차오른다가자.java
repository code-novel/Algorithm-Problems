import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자{
	//편의상 문 A,B,C,D,E,F는 0,1,2,3,4,5로 하고
	//열쇠는 10,11,12,13,14,15로한다.
	//움직일수 있는 공간은 6으로, 벽은 7로 하며
	//출9는 9로한다.
	public static int N, M;
	public static int[][]map;
	public static Node ms;
	public static int ans=-1;
	public static int[]dr= {-1,1,0,0};
	public static int[]dc= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], 7);//주위에 벽을 둘러준다.
		}
		for(int i=1;i<=N;++i) {
			String s=br.readLine();
			for(int j=1;j<=M;++j) {
				char tmp=s.charAt(j-1);
				if(tmp=='0') {
					ms=new Node(i,j,0);
					map[i][j]=6;
				}else if(tmp=='.') {
					map[i][j]=6;
				}else if(tmp=='#') {
					map[i][j]=7;
				}else if(tmp=='1') {
					map[i][j]=9;
				}else if(tmp-'a'>-1&&tmp-'a'<6){
					map[i][j]=tmp-'a'+10;
				}else {
					map[i][j]=tmp-'A';
				}
			}
		}
		bfs();
		System.out.println(ans);
	}
	public static void bfs() {
		boolean[][][] visited=new boolean[64][N+2][M+2];
		Queue<Node> q=new LinkedList<>();
		q.add(ms);
		visited[ms.key][ms.r][ms.c]=true;
		int time=0;
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int qq=0;qq<q_size;++qq) {
				Node n=q.poll();
				if(map[n.r][n.c]==9) {
					ans=time;
					return;
				}else if(map[n.r][n.c]>9) {
					n.key|=1<<(map[n.r][n.c]-10);
					visited[n.key][n.r][n.c]=true;
				}
				for(int i=0;i<4;++i) {
					int nr=n.r+dr[i];
					int nc=n.c+dc[i];
					if(map[nr][nc]!=7&&!visited[n.key][nr][nc]) {
						visited[n.key][nr][nc]=true;
						if(map[nr][nc]<6&&(n.key&(1<<map[nr][nc]))==0) {
							continue;
						}else {
							q.add(new Node(nr,nc,n.key));
						}
					}
				}
			}
			time++;
		}
	}
	
	public static class Node{
		int r;
		int c;
		int key;
		public Node(int r, int c, int key) {
			this.r=r;
			this.c=c;
			this.key=key;
		}
	}
}