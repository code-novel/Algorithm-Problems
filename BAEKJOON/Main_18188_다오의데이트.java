import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18188_다오의데이트{
	public static int H, W, N;
	public static char [][] map;
	public static Node dao,dizini;
	public static String[] moving;
	public static char[] path;
	public static int res=-1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		map=new char[H][W];
		for(int i=0;i<H;++i) {
			String s=br.readLine();
			for(int j=0;j<W;++j) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='D') {
					map[i][j]='.';
					dao=new Node(i,j);
				}else if(map[i][j]=='Z') {
					dizini=new Node(i,j);
				}
			}
		}
		N=Integer.parseInt(br.readLine());
		moving=new String[N];
		char[] root=new char[N];
		for(int i=0;i<N;++i) {
			moving[i]=br.readLine();
		}
		dfs(dao.r,dao.c,0,root);
		if(res==-1) System.out.println("NO");
		else {
			System.out.println("YES");
			for(int i=0;i<res;++i) {
				System.out.print(path[i]);
			}
		}
	}
	public static void dfs(int r, int c, int idx,char[] root) {
		if(r==dizini.r&&c==dizini.c) {
			path=root.clone();
			res=idx;
			return;
		}else if(idx==N){
			return;
		}else {
			StringTokenizer st=new StringTokenizer(moving[idx]);
			for(int k=0;k<2;++k) {
				char d=st.nextToken().charAt(0);
				root[idx]=d;
				int nr=r+dr(d);
				int nc=c+dc(d);
				if(nr>-1&&nc>-1&&nr<H&&nc<W&&map[nr][nc]!='@') {
					dfs(nr,nc,idx+1,root);
				}
			}
		}
	}
	public static int dr(char d) {
		if(d=='W') return -1;
		else if(d=='S') return 1;
		else return 0;
	}
	public static int dc(char d) {
		if(d=='A') return -1;
		else if(d=='D') return 1;
		else return 0;
	}
	public static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}