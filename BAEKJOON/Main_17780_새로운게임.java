import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17780_새로운게임{
	public static int N, K;
	public static int map[][];	//0은 흰색, 1은 빨간색, 2는 파란색
	public static int mal[][];	//말의 위치 정보와 방향 1은 오른쪽, 2는 왼쪽, 3은 위, 4는 아래.
	public static int top[][][];	//그칸의 길이, 아래, 맨위 정보
	public static boolean stop[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		map=new int[N+2][N+2];
		mal=new int[K+1][3];
		stop=new boolean[K+1];
		top=new int[N+2][N+2][3];
		for(int i=0;i<N+2;++i) {
			Arrays.fill(map[i], 2);
		}
		for(int i=1;i<=N;++i) {
			st =new StringTokenizer(br.readLine());
			for(int j=1;j<=N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}for(int i=1;i<=K;++i) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<3;++j) {
				mal[i][j]=Integer.parseInt(st.nextToken());
			}
			top[mal[i][0]][mal[i][1]][0]=1;
			top[mal[i][0]][mal[i][1]][1]=top[mal[i][0]][mal[i][1]][2]=i;
		}
		int time=1;
		out :
		while (time<1001) {
			for(int i=1;i<=K;++i) {
				if(!stop[i]) {
					boolean a=move(i);
					if(a) break out;
				}
			}			
			time++;	
		}
		if(time>1000) {
			time=-1;
		}
		System.out.println(time);
	}
	public static boolean move(int k) {
		int r,c,nr,nc;
		r=nr=mal[k][0];
		c=nc=mal[k][1];
		switch(mal[k][2]) {
			case 1 : nc++;	//오른쪽
			break;
			case 2 : nc--;	//왼쪽
			break;
			case 3 : nr--;	//위쪽
			break;
			case 4 : nr++;	//아래쪽
			break;
		}
		if(map[nr][nc]==2) {
			switch(mal[k][2]) {
			case 1 :
				nc-=2;	//오른쪽
				mal[k][2]=2;
			break;
			case 2 :
				nc+=2;	//왼쪽
				mal[k][2]=1;
			break;
			case 3 :
				nr+=2;	//위쪽
				mal[k][2]=4;
			break;
			case 4 :
				nr-=2;	//아래쪽
				mal[k][2]=3;
			break;
			}
		}
		if(map[nr][nc]==1&&top[r][c][0]!=1) {
			int tmp=top[r][c][1];
			top[r][c][1]=top[r][c][2];
			top[r][c][2]=tmp;
			stop[top[r][c][1]]=false;
			stop[top[r][c][2]]=true;
			k=top[r][c][1];
		}
		if(map[nr][nc]!=2) {
			if(top[nr][nc][0]!=0) {
				int len=top[nr][nc][0]+top[r][c][0];
				if(len>3) {
					return true;
				}else {
					stop[top[r][c][1]]=true;
					top[nr][nc][0]=len;
					top[nr][nc][2]=top[r][c][2];
					mal[k][0]=nr;
					mal[k][1]=nc;
					top[r][c]=new int[] {0,0,0};
					return false;
				}
			}else {
				top[nr][nc][0]=top[r][c][0];
				top[nr][nc][1]=top[r][c][1];
				top[nr][nc][2]=top[r][c][2];
				mal[k][0]=nr;
				mal[k][1]=nc;
				top[r][c]=new int[] {0,0,0};
				return false;
			}
		}
		mal[k][0]=r;
		mal[k][1]=c;
		return false;
	}
}