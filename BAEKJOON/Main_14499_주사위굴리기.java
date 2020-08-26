import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기{
	public static int N, M, x, y, K;
	public static int [][]map;
	public static int []dice=new int[6];
	// 0 : 밑 1 : 동 2 : 서 3 : 북 : 4 : 남 5 : 윗면
	//동 : 1 서 : 2 북 : 3 남 : 4
	public static int[]dx= {0,0,0,-1,1};
	public static int[]dy= {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new int[N+2][M+2];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], -1);
		}
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int r=x+1; int c=y+1;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;++i) {
			int k=Integer.parseInt(st.nextToken());
			if(map[r+dx[k]][c+dy[k]]<0)continue;
			turn(k);
			r+=dx[k];
			c+=dy[k];
			if(map[r][c]==0) {
				map[r][c]=dice[0];
			}else {
				dice[0]=map[r][c];
				map[r][c]=0;
			}
			System.out.println(dice[5]);
		}
	}
	public static void turn(int d) {
		if(d==1) {
			int tmp=dice[0];
			dice[0]=dice[1];
			dice[1]=dice[5];
			dice[5]=dice[2];
			dice[2]=tmp;
		}else if(d==2) {
			int tmp=dice[0];
			dice[0]=dice[2];
			dice[2]=dice[5];
			dice[5]=dice[1];
			dice[1]=tmp;
		}else if(d==3) {
			int tmp=dice[0];
			dice[0]=dice[3];
			dice[3]=dice[5];
			dice[5]=dice[4];
			dice[4]=tmp;
		}else if(d==4) {
			int tmp=dice[0];
			dice[0]=dice[4];
			dice[4]=dice[5];
			dice[5]=dice[3];
			dice[3]=tmp;
		}
	}
}