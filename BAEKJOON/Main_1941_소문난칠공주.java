import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1941_소문난칠공주{
	public static char[][]map=new char[5][5];
	public static boolean[] visited=new boolean[1<<25];
	public static int dr[]= {-1,1,0,0};
	public static int dc[]= {0,0,-1,1};
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;++i) {
			String s=br.readLine();
			for(int j=0;j<5;++j) {
				map[i][j]=s.charAt(j);
			}
		}
		for(int i=0;i<5;++i) {
			for(int j=0;j<5;++j) {
				visited[1<<(i*5+j)]=true;
				if(map[i][j]=='Y') dfs(1<<(i*5+j),0,1);
				else dfs(1<<(i*5+j),0,0);
			}
		}
		System.out.println(ans);
	}
	public static void dfs(int now, int idx, int sel) {
		if(idx==6) {
			if(sel<4) ans++;
			return;
		}else {
			for(int i=0;i<25;++i) {
				if((now&(1<<i))==0) continue;
				int r=i/5;
				int c=i%5;
				for(int j=0;j<4;++j) {
					int nr=r+dr[j];
					int nc=c+dc[j];
					int bit=nr*5+nc;
					if((now&(1<<bit))!=0) continue;
					if(nr>-1&&nc>-1&&nr<5&&nc<5&&!visited[now|(1<<bit)]) {
						visited[now|(1<<bit)]=true;
						if(map[nr][nc]=='Y') {
							if(sel==3) continue;
							else {
								dfs(now|1<<(bit),idx+1, sel+1);
							}
						}
						else{
							dfs(now|1<<(bit),idx+1, sel);
						}
					}
				}
			}
		}
	}
}