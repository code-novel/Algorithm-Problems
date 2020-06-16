import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18242_네모네모시력검사 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char map[][]=new char [N][M];
		for(int i=0;i<N;++i) {
			String s=br.readLine();
			for(int j=0;j<M;++j) {
				map[i][j]=s.charAt(j);
			}
		}
		int nx=0, ny=0, cnt=0;
		String ans="";
		out:
		for(int i=0;i<N;++i) {
			for(int j=0;j<M;++j) {
				if(map[i][j]=='#') {
					nx=i;ny=j;
					int xcnt=0,ycnt=0;
					while(j!=M&&map[i][j]=='#') {
						j++;
						xcnt++;
					}
					j=ny;
					while(i!=N&&map[i][j]=='#') {
						i++;
						ycnt++;
					}
					cnt=xcnt>ycnt?xcnt:ycnt;
					break out;
				}
			}
		}
		if(map[nx][ny+(cnt/2)]=='.')ans="UP";
		else if(map[nx+(cnt/2)][ny]=='.')ans="LEFT";
		else if(map[nx+(cnt/2)][ny+cnt-1]=='.')ans="RIGHT";
		else if(map[nx+cnt-1][ny+(cnt/2)]=='.')ans="DOWN";
		System.out.println(ans);
	}

}
