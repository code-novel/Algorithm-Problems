import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법상어와토네이도 {
	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static int r,c,d;
	public static int dr[]= {0,1,0,-1};
	public static int dc[]= {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N+4][N+4];
		visited=new boolean[N+4][N+4];
		for(int i=2;i<N+2;++i) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=2;j<N+2;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int start=(N+4)/2;
		visited[start][start]=true;
		visited[start][start-1]=true;
		r=start;
		c=start-1;
		d=0;
		for(int i=0;i<N*N-1;++i) {
			sand();
			move();
		}
		int ans=0;
		for(int i=0;i<2;++i) {
			for(int j=0;j<N+4;++j) {
				ans+=map[i][j];
			}
		}
		for(int i=N+2;i<N+4;++i) {
			for(int j=0;j<N+4;++j) {
				ans+=map[i][j];
			}
		}
		for(int i=2;i<N+2;++i) {
			for(int j=0;j<2;++j) {
				ans+=map[i][j];
			}
		}
		for(int i=2;i<N+2;++i) {
			for(int j=N+2;j<N+4;++j) {
				ans+=map[i][j];
			}
		}
		System.out.println(ans);
	}
	public static void move() {
		int nd=turn(d);
		int nr=r+dr[nd];
		int nc=c+dc[nd];
		if(!visited[nr][nc]) {
			r=nr;
			c=nc;
			d=nd;
			visited[nr][nc]=true;
		}else {
			r+=dr[d];
			c+=dc[d];
			visited[r][c]=true;
		}
	}
	public static int turn(int i) {
		if(i==3) return 0;
		else return i+1;
	}
	public static void sand() {
		int now=map[r][c];
		int ten=now*10/100;
		int seven=now*7/100;
		int five=now*5/100;
		int two=now*2/100;
		int one=now/100;
		int alpha=now-(2*ten+2*seven+five+2*two+2*one);
		switch(d) {
		case 0:
			map[r][c-1]+=alpha;
			map[r][c-2]+=five;
			map[r-1][c]+=seven;
			map[r+1][c]+=seven;
			map[r-2][c]+=two;
			map[r+2][c]+=two;
			map[r-1][c+1]+=one;
			map[r+1][c+1]+=one;
			map[r-1][c-1]+=ten;
			map[r+1][c-1]+=ten;
			map[r][c]=0;
			break;
		case 1:
			map[r+1][c]+=alpha;
			map[r+2][c]+=five;
			map[r][c-1]+=seven;
			map[r][c+1]+=seven;
			map[r][c-2]+=two;
			map[r][c+2]+=two;
			map[r-1][c+1]+=one;
			map[r-1][c-1]+=one;
			map[r+1][c+1]+=ten;
			map[r+1][c-1]+=ten;
			map[r][c]=0;
			break;
		case 2:
			map[r][c+1]+=alpha;
			map[r][c+2]+=five;
			map[r-1][c]+=seven;
			map[r+1][c]+=seven;
			map[r-2][c]+=two;
			map[r+2][c]+=two;
			map[r-1][c-1]+=one;
			map[r+1][c-1]+=one;
			map[r-1][c+1]+=ten;
			map[r+1][c+1]+=ten;
			map[r][c]=0;
			break;
		case 3:
			map[r-1][c]+=alpha;
			map[r-2][c]+=five;
			map[r][c-1]+=seven;
			map[r][c+1]+=seven;
			map[r][c-2]+=two;
			map[r][c+2]+=two;
			map[r+1][c+1]+=one;
			map[r+1][c-1]+=one;
			map[r-1][c+1]+=ten;
			map[r-1][c-1]+=ten;
			map[r][c]=0;
			break;
		}
	}
}