import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳{
	public static int R, C;
	public static char map[][];
	public static boolean[] alphabet=new boolean[26];
	public static int max=1;
	public static int dx[]= {-1,1,0,0};
	public static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R+2][C+2];
		for(int i=1; i<=R; ++i) {
			String s=br.readLine();
			for(int j=1;j<=C;++j) {
				map[i][j]=s.charAt(j-1);
			}
		}
		alphabet[map[1][1]-'A']=true;
		dfs(1,1,1);
		System.out.println(max);
	}
	public static void dfs(int r, int c, int cnt) {
		if(cnt>max) {
			max=Math.max(cnt, max);
		}
		for(int i=0; i<4;++i) {
			int nr=r+dx[i];
			int nc=c+dy[i];
			int num=map[nr][nc]-'A';
			if(num>-1&&num<26&&!alphabet[num]) {
				alphabet[num]=true;
				dfs(nr,nc,cnt+1);
				alphabet[num]=false;
			}
		}
	}
}