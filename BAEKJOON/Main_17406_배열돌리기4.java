import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4{
	public static int N, M, K;
	public static int[][] map;
	public static int[][] turn;
	public static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		turn=new int[K+1][3];
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1;i<=K;++i) {
			st=new StringTokenizer(br.readLine());
			turn[i][0]=Integer.parseInt(st.nextToken());
			turn[i][1]=Integer.parseInt(st.nextToken());
			turn[i][2]=Integer.parseInt(st.nextToken());
		}
		boolean[]isUsed=new boolean[K+1];
		int []sunseo=new int[K];
		permutation(0,isUsed,sunseo);
		System.out.println(min);
	}
	public static void permutation(int idx, boolean[]isUsed,int[] sunseo) {
		if(idx==K) {
			//순서가 정해졌으면 회전을 합시다!
			int [][]tmp=copyMap();
			for(int i=0;i<K;++i) {
				rotate(turn[sunseo[i]][0],turn[sunseo[i]][1],turn[sunseo[i]][2]);
			}
			int minS=Integer.MAX_VALUE;
			for(int i=1;i<=N;++i) {
				int score=0;
				for(int j=1;j<=M;++j) {
					score+=map[i][j];
				}
				minS=Math.min(score, minS);
			}
			min=Math.min(minS, min);
			for(int i=1;i<=N;++i) {
				for(int j=1;j<=M;++j) {
					map[i][j]=tmp[i][j];
				}
			}
			return;
		}else {
			for(int i=1;i<=K;++i) {
				if(!isUsed[i]) {
					isUsed[i]=true;
					sunseo[idx]=i;
					permutation(idx+1,isUsed,sunseo);
					isUsed[i]=false;
					sunseo[idx]=0;
				}
			}
		}
	}
	public static void rotate(int r, int c, int s) {
		int dx[]= {0,1,0,-1};
		int dy[]= {1,0,-1,0};
		for(int i=1;i<=s;++i) {
			int nr=r-i;
			int nc=c-i;
			int d=0;
			int tmp=map[nr][nc];
			map[nr][nc]=map[nr+1][nc];
			do{
				if (nr+dx[d]<r-i||nr+dx[d]>r+i||nc+dy[d]<c-i||nc+dy[d]>c+i)d=changeDir(d);
				int tmp2=map[nr+dx[d]][nc+dy[d]];
				map[nr+dx[d]][nc+dy[d]]=tmp;
				tmp=tmp2;
				nr+=dx[d];
				nc+=dy[d];
			}while(!(nr==r-i&&nc==c-i));
		}
	}
	public static int[][] copyMap() {
		int tmpMap[][]=new int[N+1][M+1];
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=M;++j) {
				tmpMap[i][j]=map[i][j];
			}
		}
		return tmpMap;
	}
	public static int changeDir(int d) {
		if(d==3) return 0;
		else return d+1;
	}
}