import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	public static char map[][];
	public static int[] dirR= {-1,1,0,0};
	public static int[] dirC= {0,0,-1,1};
	public static ArrayList<int[]> list=new ArrayList<int[]>();
	public static ArrayList<int[]> list2=new ArrayList<int[]>();
	public static boolean isVisited[][];
	public static int cnt=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		map=new char[R+2][C+2];
		for(int i=1;i<=R;++i) {
			String S=br.readLine();
			for(int j=1;j<=C;++j) {
				map[i][j]=S.charAt(j-1);
				if(map[i][j]=='S') {
					list.add(new int[] {i,j});
				}
			}
		}
		out:
		while(true) {
			isVisited=new boolean[R+2][C+2];
			for(int i=0; i<list.size();++i) {
				int r=list.get(i)[0];
				int c=list.get(i)[1];
				if(map[r][c]!='S') continue;
				else {
					for(int j=0; j<4;++j) {
						int nr=r+dirR[j];
						int nc=c+dirC[j];
						if(map[nr][nc]=='.') {
							map[nr][nc]='S';
							list2.add(new int[]{nr,nc});
						}else if(map[nr][nc]=='D') {
							System.out.println(cnt);
							break out;
						}
					}
					map[r][c]='s';
				}
			}
			list.clear();
			list.addAll(list2);
			list2.clear();
			loop:
			for(int i=1;i<=R;++i) {
				for(int j=1;j<=C;++j) {
					if(!isVisited[i][j]&&map[i][j]=='*') {
						isVisited[i][j]=true;
						dfs(i,j);
						break loop;
					}
				}
			}
			boolean flag=false;
			for(int i=1;i<=R;++i) {
				for(int j=1;j<=C;++j) {
					if(map[i][j]=='S') flag=true;
				}
			}
			if(!flag) {
				System.out.println("KAKTUS");
				break out;
			}
			cnt++;
		}
	}
	private static void dfs(int r, int c) {
		for(int i=0;i<4;++i) {
			int nr=r+dirR[i];
			int nc=c+dirC[i];
			if(!isVisited[nr][nc]&&(map[nr][nc]=='.'||map[nr][nc]=='s'||map[nr][nc]=='S')) {
				map[nr][nc]='*';
				isVisited[nr][nc]=true;
			}else if(!isVisited[nr][nc]&&map[nr][nc]=='*') {
				isVisited[nr][nc]=true;
				dfs(nr,nc);
			}
		}
	}
	
}
