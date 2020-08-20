import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기{
	public static int N,M,T;
	public static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
			map[i][0]=map[i][M];
		}
		for(int i=0;i<T;++i) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			move(x,d,k);
			delete();
		}
		int ans=0;
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=M;++j) {
				if(map[i][j]!=0) {
					ans+=map[i][j];
				}
			}
		}
		System.out.println(ans);
	}
	public static void move(int x, int d, int k) {
		if(d==0) {//시계방향
			for(int i=1;i<=N/x;++i) {
				int tmp[]=new int[k];
				for(int j=M-k+1;j<=M;++j) {
					tmp[j-M+k-1]=map[i*x][j];
				}
				for(int j=M-k;j>0;--j) {
					map[i*x][j+k]=map[i*x][j];
				}
				for(int j=1;j<=k;++j) {
					map[i*x][j]=tmp[j-1];
				}
				map[i*x][0]=map[i*x][M];
			}
		}else if(d==1) {	//반시계방향
			for(int i=1;i<=N/x;++i) {
				int tmp[]=new int[k];
				for(int j=1;j<=k;++j) {
					tmp[j-1]=map[i*x][j];
				}
				for(int j=k+1;j<=M;++j) {
					map[i*x][j-k]=map[i*x][j];
				}
				for(int j=M-k+1;j<=M;++j) {
					map[i*x][j]=tmp[j+k-M-1];
				}
				map[i*x][0]=map[i*x][M];
			}
		}
	}
	public static void delete() {
		boolean[][] check=new boolean[N+1][M+1];	//지울부분을 저장
		for(int i=1;i<=N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]!=0&&map[i][j]==map[i][j+1]) {
					check[i][j]=check[i][j+1]=true;
				}
			}
			if(check[i][0])check[i][M]=true;
		}
		for(int i=1;i<=M;++i) {
			for(int j=1;j<N;++j) {
				if(map[j][i]!=0&&map[j][i]==map[j+1][i]) {
					check[j][i]=check[j+1][i]=true;
				}
			}
		}
		boolean isChange=false;
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=M;++j) {
				if(check[i][j]) {
					isChange=true;
					map[i][j]=0;
				}
			}
		}
		if(!isChange) {
			int cnt=0;
			int total=0;
			for(int i=1;i<=N;++i) {
				for(int j=1;j<=M;++j) {
					if(map[i][j]!=0) {
						cnt++;
						total+=map[i][j];
					}
				}
			}
			float avg=(float)total/cnt;
			for(int i=1;i<=N;++i) {
				for(int j=1;j<=M;++j) {
					if(map[i][j]!=0&&map[i][j]>avg) {
						map[i][j]--;
					}else if(map[i][j]!=0&&map[i][j]<avg) {
						map[i][j]++;
					}
				}
				map[i][0]=map[i][M];
			}
		}
	}
}
