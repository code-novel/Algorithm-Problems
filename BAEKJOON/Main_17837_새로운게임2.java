import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2{
	public static int N, K;
	public static int map[][];	//0은 흰색, 1은 빨간색, 2는 파란색
	public static int mal[][];	//말의 위치 정보와 방향 1은 오른쪽, 2는 왼쪽, 3은 위, 4는 아래 말의 층
	public static int top[][][];	//그칸의 길이, 1층 2층 3층
	public static boolean stop[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		map=new int[N+2][N+2];
		mal=new int[K+1][4];
		top=new int[N+2][N+2][4];
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
			mal[i][3]=1;
			top[mal[i][0]][mal[i][1]][0]=1;
			top[mal[i][0]][mal[i][1]][1]=i;
		}
		int time=1;
		out :
		while (time<1001) {
			for(int i=1;i<=K;++i) {
				boolean a=move(i);
				if(a) break out;
			}			
			time++;	
		}
		if(time>1000) {
			time=-1;
		}
		System.out.println(time);
	}
	public static boolean move(int k) {
		int r,c,nr,nc,floor;
		r=nr=mal[k][0];
		c=nc=mal[k][1];
		floor=mal[k][3];
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
		if(map[nr][nc]==1&&top[r][c][0]-floor!=0) {
			top[r][c]=swap(top[r][c],floor);
		}
		if(map[nr][nc]!=2) {
			if(top[nr][nc][0]!=0) {
				int len=top[nr][nc][0]+top[r][c][0]+1-floor;
				if(len>3) {
					return true;
				}else {
					for(int i=floor;i<=top[r][c][0];++i) {
						top[nr][nc][top[nr][nc][0]+1-floor+i]=top[r][c][i];
						mal[top[nr][nc][top[nr][nc][0]+1-floor+i]][0]=nr;
						mal[top[nr][nc][top[nr][nc][0]+1-floor+i]][1]=nc;
						mal[top[nr][nc][top[nr][nc][0]+1-floor+i]][3]=top[nr][nc][0]+1-floor+i;
					}
					top[nr][nc][0]=len;
					top[r][c][0]=floor-1;
					for(int i=top[r][c][0]+1;i<4;++i) {
						top[r][c][i]=0;
					}
					return false;
				}
			}else {
				top[nr][nc][0]=top[r][c][0]-floor+1;
				for(int i=floor;i<=top[r][c][0];++i) {
					top[nr][nc][i-floor+1]=top[r][c][i];
				}
				for(int i=1;i<=top[nr][nc][0];++i) {
					mal[top[nr][nc][i]][0]=nr;
					mal[top[nr][nc][i]][1]=nc;
					mal[top[nr][nc][i]][3]=i;
				}
				top[r][c][0]=floor-1;
				for(int i=top[r][c][0]+1;i<4;++i) {
					top[r][c][i]=0;
				}
				return false;
			}
		}
		return false;
	}
	public static int[] swap(int[] arr, int floor) {
		int tmp=arr[floor];
		arr[floor]=arr[arr[0]];
		arr[arr[0]]=tmp;
		mal[arr[floor]][3]=floor;
		mal[arr[arr[0]]][3]=arr[0];
		return arr;
	}
}
