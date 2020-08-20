import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19236_청소년상어{
	public static int[][]map=new int[6][6];
	public static int[][]dir=new int[6][6];
	public static int[]dx= {0,-1,-1,0,1,1,1,0,-1};
	public static int[]dy= {0,0,-1,-1,-1,0,1,1,1};
	public static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=1;i<=4;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=4;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dir[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,1,0);
		System.out.println(max);
	}
	public static void dfs(int r, int c,int score) {
		if(map[r][c]==0) {
			max=Math.max(score, max);
			return;
		}else {
			int eat=map[r][c];
			map[r][c]=0;
			move(r,c);
			int[][]tmpMap=new int[6][6];
			int[][]tmpDir=new int[6][6];
			for(int i=1;i<=4;++i) {
				for(int j=1;j<=4;++j) {
					tmpMap[i][j]=map[i][j];
					tmpDir[i][j]=dir[i][j];
				}
			}
			int time=1;
			while(true) {
				int nr=r+dx[dir[r][c]]*time;
				int nc=c+dy[dir[r][c]]*time;
				if(nr<0||nc<0||nr>5||nc>5)break;
				else {
					dfs(nr,nc,score+eat);
					for(int i=1;i<=4;++i) {
						for(int j=1;j<=4;++j) {
							map[i][j]=tmpMap[i][j];
							dir[i][j]=tmpDir[i][j];
						}
					}
				}
				time++;
			}
			map[r][c]=eat;
		}
	}
	public static void move(int a, int b) {
		for(int i=1;i<=16;++i) {
			int r=0; int c=0;
			for(int j=1;j<=4;++j) {
				for(int k=1;k<=4;++k) {
					if(map[j][k]==i) {
						r=j;c=k;
					}
				}
			}
			if(map[r][c]==0)continue;
			int tmpd=dir[r][c];
			do {
				int nr=r+dx[tmpd];
				int nc=c+dy[tmpd];
				if(!(nr==a&&nc==b)&&(nr>0&&nc>0&&nr<5&&nc<5)) {
					//change
					dir[r][c]=tmpd;
					change(r,c,nr,nc);
					break;
				}else {
					if(tmpd!=8) tmpd++;
					else tmpd=1;
				}
			}while(tmpd!=dir[r][c]);
		}
	}
	public static void change(int r, int c, int nr,int nc) {
		int tmpA=map[r][c];
		int tmpB=dir[r][c];
		map[r][c]=map[nr][nc];
		dir[r][c]=dir[nr][nc];
		map[nr][nc]=tmpA;
		dir[nr][nc]=tmpB;
	}
}