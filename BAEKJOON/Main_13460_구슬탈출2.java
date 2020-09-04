import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2{
	public static int N, M;
	public static char[][]map;
	public static int[]dx= {0,0,-1,1};	//0은 왼쪽, 1은 오른쪽
	public static int[]dy= {-1,1,0,0};	//2는 윗쪽, 3은 아랫쪽
	public static Ball blue, red;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		red=new Ball(0,0,'R',false);
		blue=new Ball(0,0,'B',false);
		for(int i=0;i<N;++i) {
			String s=br.readLine(); 
			for(int j=0;j<M;++j) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='R') {
					red.r=i;
					red.c=j;
					map[i][j]='.';
				}
				else if(map[i][j]=='B') {
					blue.r=i;
					blue.c=j;
					map[i][j]='.';
				}
			}
		}
		System.out.println(bfs());
	}
	public static int bfs () {
		Ball r=new Ball(red.r,red.c,red.color,red.out);
		Ball b=new Ball(blue.r,blue.c,blue.color,blue.out);
		Set start=new Set(r,b);
		Queue<Set> q=new LinkedList<>();
		q.add(start);
		int cnt=1;
		while(!q.isEmpty()&&cnt<11) {
			int q_size=q.size();
			for(int i=0;i<q_size;++i) {
				Set tmp=q.poll();
				for(int j=0;j<4;++j) {	//4방향으로 탐색을 하는데...
					boolean first=true;	//first이면 빨간공을 먼저 움직인다.
					if(j==0) {	//왼쪽
						if(tmp.red.c>tmp.blue.c) {
							first=false;
						}
					}else if(j==1) {	//오른쪽
						if(tmp.red.c<tmp.blue.c) {
							first=false;
						}
					}else if(j==2) {	//윗쪽
						if(tmp.red.r>tmp.blue.r) {
							first=false;
						}
					}else if(j==3) {
						if(tmp.red.r<tmp.blue.r) {
							first=false;
						}
					}
					Set res=move(tmp,j,first);
					if(!res.blue.out&&res.red.out) {
						return cnt;
					}else if(!res.blue.out&&!res.red.out) {
						q.add(res);
					}
				}
			}
			cnt++;
		}
		return -1;
	}
	public static Set move(Set s, int d, boolean first) {
		Ball red=new Ball(s.red.r,s.red.c,s.red.color,s.red.out);
		Ball blue=new Ball(s.blue.r,s.blue.c,s.blue.color,s.blue.out);
		if(first) {
			moveBall(red,d);
			moveBall(blue,d);
			map[red.r][red.c]='.';
			map[blue.r][blue.c]='.';
		}else {
			moveBall(blue,d);
			moveBall(red,d);
			map[red.r][red.c]='.';
			map[blue.r][blue.c]='.';
		}
		return new Set(red, blue);
	}
	public static void moveBall(Ball b,int d) {
		int bnr=b.r+dx[d];
		int bnc=b.c+dy[d];
		while(map[bnr][bnc]=='.') {
			bnr+=dx[d];
			bnc+=dy[d];
		}
		if(map[bnr][bnc]=='O') {
			map[b.r][b.c]='.';
			b.out=true;
		}else{
			bnr-=dx[d];
			bnc-=dy[d];
			b.r=bnr;
			b.c=bnc;
			map[b.r][b.c]=b.color;
		}
	}
	public static class Set{
		Ball red;
		Ball blue;
		public Set(Ball r, Ball b) {
			this.red=r;
			this.blue=b;
		}
	}
	public static class Ball{
		int r;
		int c;
		char color;
		boolean out;
		public Ball(int r, int c,char color,boolean out) {
			this.r=r;
			this.c=c;
			this.color=color;
			this.out=out;
		}
	}
}