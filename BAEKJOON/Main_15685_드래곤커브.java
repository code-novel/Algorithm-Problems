import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브{
	public static int N;
	public static int dr[]= {1,0,-1,0};	//남, 서, 북, 동
	public static int dc[]= {0,-1,0,1};
	public static ArrayList<Dragon>[] list;
	public static boolean[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new boolean[101][101];
		list=new ArrayList[N];
		StringTokenizer st;
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			list[i]=new ArrayList<>();
			list[i].add(new Dragon(x,y,d));
			map[x][y]=true;
			dragonCurve(i,g);
		}
		System.out.println(getAnswer());
	}
	public static int getAnswer() {
		int ans=0;
		for(int i=0;i<100;++i) {
			for(int j=0;j<100;++j) {
				if(map[i][j]&&map[i+1][j]&&map[i][j+1]&&map[i+1][j+1]) {
					ans++;
				}
			}
		}
		return ans;
	}
	public static void dragonCurve(int i,int g) {
		if(g==0) {
			Dragon last=list[i].get(list[i].size()-1);
			int nr=last.x+dr[last.d];
			int nc=last.y+dc[last.d];
			map[nr][nc]=true;
			return;
		}
		int size=list[i].size()-1;
		for(int j=size;j>-1;--j) {
			Dragon last=list[i].get(list[i].size()-1);
			Dragon now=list[i].get(j);
			int d=plusD(now.d);
			int nr=last.x+dr[last.d];
			int nc=last.y+dc[last.d];
			map[nr][nc]=true;
			list[i].add(new Dragon(nr,nc,d));
		}
		dragonCurve(i,g-1);
	}
	public static int plusD(int d) {
		if(d==3) return 0;
		return d+1;
	}
	public static class Dragon{
		int x;
		int y;
		int d;
		public Dragon(int x, int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
}