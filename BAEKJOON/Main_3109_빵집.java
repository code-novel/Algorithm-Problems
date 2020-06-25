import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	public static int R, C;
	public static char[][] map;
	public static boolean isVisited[][];
	public static boolean chk=false;
	public static int cnt=0;
	public static int dirR[]=new int[] {-1,0,1};	//C는 항상 1증가 하므로 생략
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R+2][C+2];
		isVisited=new boolean[R+2][C+2];
		for(int i=1; i<=R;++i) {
			String s= br.readLine();
			for(int j=1; j<=C;++j) {
				map[i][j]=s.charAt(j-1);
			}
		}
		for(int i=1;i<=R;++i) {
			dfs(i,1);
			if(chk) {cnt++;chk=false;}
		}
		System.out.println(cnt);
	}
	public static void dfs(int r, int c) {
		isVisited[r][c]=true;
		if(c==C-1) {
			chk=true;
			return;
		}
		else {
			for(int i=0;i<3;++i) {
				int nr=r+dirR[i];
				int nc=c+1;
				if(!isVisited[nr][nc]&&map[nr][nc]=='.'&&!chk) {
					dfs(nr,nc);
				}
			}
		}
	}
}
