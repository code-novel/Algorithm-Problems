import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_19237_어른상어{
	public static int N, M, K;
	public static int time=1;
	public static int map[][];
	public static int scent[][][];
	public static int []dx= {0,-1,1,0,0};
	public static int []dy= {0,0,0,-1,1};
	public static HashMap<Integer, Shark> shark=new HashMap<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		scent=new int[2][N+1][N+1];
		for(int i=1;i<N+1;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					shark.put(map[i][j], new Shark(i, j));
					scent[0][i][j]=map[i][j];
					scent[1][i][j]=K;
				}
			}
		}
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=M;++i) {
			Shark tmp=shark.get(i);
			tmp.d=Integer.parseInt(st.nextToken());
			shark.put(i,tmp);
		}
		for(int i=1;i<=M;++i) {
			Shark tmp=shark.get(i);
			int [][]dir=new int[5][4];
			for(int j=1;j<5;++j) {
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<4;++k) {
					dir[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			tmp.dir=dir;
			shark.put(i, tmp);
		}
		while(true) {
			for(int i=1;i<=M;++i) {
				if(shark.containsKey(i)) move(i);
			}
			goTime();	//시간을 줄이고
			spread();	//새로 상어가 간 곳에 다른 상어 있는지 확인 후 향기를 뿌림.
			if(shark.size()==1) {
				break;
			}
			time++;
			if(time==1001) {
				time=-1;
				break;
			}
		}
		System.out.println(time);
	}
	
	public static void goTime() {
		for(int i=1;i<N+1;++i) {
			for(int j=1;j<N+1;++j) {
				if(scent[0][i][j]!=0) {
					scent[1][i][j]-=1;
					if(scent[1][i][j]==0) {
						scent[0][i][j]=0;
					}
				}
			}
		}
	}
	public static void spread() {
		int [][] tmpMap=new int[N+1][N+1];
		for(int i=1;i<=M;++i) {
			if(shark.containsKey(i)) {
				Shark tmp=shark.get(i);
				if(tmpMap[tmp.r][tmp.c]!=0) {
					shark.remove(i);
					continue;
				}else {
					tmpMap[tmp.r][tmp.c]=i;
					scent[0][tmp.r][tmp.c]=i;
					scent[1][tmp.r][tmp.c]=K;
				}
			}
		}
		for(int i=1;i<N+1;++i) {
			for(int j=1;j<N+1;++j) {
				map[i][j]=tmpMap[i][j];
			}
		}
	}
	public static void move(int n) {
		Shark now=shark.get(n);
		for(int i=0;i<4;++i) {
			int nr=now.r+dx[now.dir[now.d][i]];
			int nc=now.c+dy[now.dir[now.d][i]];
			if(nr>0&&nc>0&&nr<N+1&&nc<N+1&&scent[0][nr][nc]==0) {
				now.r=nr;
				now.c=nc;
				now.d=now.dir[now.d][i];
				return;
			}
		}
		for(int i=0;i<4;++i) {
			int nr=now.r+dx[now.dir[now.d][i]];
			int nc=now.c+dy[now.dir[now.d][i]];
			if(nr>0&&nc>0&&nr<N+1&&nc<N+1&&scent[0][nr][nc]==n) {
				now.r=nr;
				now.c=nc;
				now.d=now.dir[now.d][i];
				return;
			}
		}
	}
	public static class Shark{
		int r;
		int c;
		int d;
		int [][]dir;
		public Shark(int r, int c) {
			this.r=r;
			this.c=c;
		}
		public Shark(int r, int c, int d) {
			this.r=r;
			this.c=c;
			this.d=d;
		}
		public Shark(int r, int c, int d, int[] up,int[][] dir) {
			this.r=r;
			this.c=c;
			this.d=d;
			this.dir=dir;
		}
	}
}