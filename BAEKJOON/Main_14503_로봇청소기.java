import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	public static void main(String[] args) throws IOException {
		int [][] dir= {{-1,0},{0,1},{1,0},{0,-1}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int [][] map = new int [N] [M];
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		first: while(true) {
			if(map[r][c]==0) {
				map[r][c]=2;
				cnt++;
			}
			int chk=0;
			second: while(true) {
				if(chk==4) {
					chk=0;
					int nr=r-dir[d][0];
					int nc=c-dir[d][1];
					if(map[nr][nc]==2) {
						r=nr;c=nc;
						continue second;
					}else {
						break first;
					}
				}
				d=(d+3)%4;
				int nr=r+dir[d][0];
				int nc=c+dir[d][1];
				if(map[nr][nc]==0) {
					r=nr;c=nc;
					continue first;
				}else {
					chk++;
					continue second;
				}
			}
		}
		System.out.println(cnt);
	}
}
