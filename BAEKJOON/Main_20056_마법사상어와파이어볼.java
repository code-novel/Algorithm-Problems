import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼{
	public static int N, M, K;
	public static ArrayList<Fireball>[][] map;
	public static int []dr= {-1,-1,0,1,1,1,0,-1};
	public static int []dc= {0,1,1,1,0,-1,-1,-1};
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new ArrayList[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=new ArrayList<>();
			}
		}
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int m=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			map[r][c].add(new Fireball(m,s,d,0));
		}
		for(int i=0;i<K;++i) {
			moveFireBall(i);
			sumFireBall(i+1);
		}
		getAnswer();
		System.out.println(ans);
	}
	public static void getAnswer() {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				int len=map[i][j].size();
				if(len==0)continue;
				for(int k=0;k<len;++k) {
					Fireball fb=map[i][j].get(k);
					ans+=fb.m;
				}
			}
		}
	}
	public static void sumFireBall(int now) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				int len=map[i][j].size();
				if(len<2)continue;
				int nm=0;
				int ns=0;
				int holl=0;
				int jjak=0;
				while(!map[i][j].isEmpty()) {
					Fireball fb=map[i][j].get(0);
					map[i][j].remove(0);
					nm+=fb.m;
					ns+=fb.s;
					if(fb.d%2==0) jjak++;
					else holl++;
				}
				nm/=5;
				ns/=len;
				if(nm!=0) {
					if(holl==0||jjak==0) {
						map[i][j].add(new Fireball(nm,ns,0,now));
						map[i][j].add(new Fireball(nm,ns,2,now));
						map[i][j].add(new Fireball(nm,ns,4,now));
						map[i][j].add(new Fireball(nm,ns,6,now));
					}else {
						map[i][j].add(new Fireball(nm,ns,1,now));
						map[i][j].add(new Fireball(nm,ns,3,now));
						map[i][j].add(new Fireball(nm,ns,5,now));
						map[i][j].add(new Fireball(nm,ns,7,now));
					}
				}
			}
		}
	}
	public static void moveFireBall(int now) {
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				if(map[i][j].size()==0)continue;
				while(!map[i][j].isEmpty()) {
					Fireball fb=map[i][j].get(0);
					if(fb.t==now) {
						map[i][j].remove(0);
						int nr=getPoint((i+dr[fb.d]*fb.s));
						int nc=getPoint((j+dc[fb.d]*fb.s));
						map[nr][nc].add(new Fireball(fb.m,fb.s,fb.d,fb.t+1));
					}else break;
				}
			}
		}
	}
	public static int getPoint(int n) {
		if(n<0) return (n+N*(-n))%N;
		return n%N;
	}
	public static class Fireball{
		int m;
		int s;
		int d;
		int t;
		public Fireball(int m, int s, int d,int t) {
			this.m=m;
			this.s=s;
			this.d=d;
			this.t=t;
		}
	}
}