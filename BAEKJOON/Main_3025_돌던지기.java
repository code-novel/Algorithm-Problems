import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3025_돌던지기{

	public static int R, C, N;
	public static char [][] map;
	public static int [] top;	//X의 위치를 저장.
	public static int [][] col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		top=new int[C];
		Arrays.fill(top, R);
		map=new char[R][C];
		col=new int[C][R];
		for(int i=0; i<R;++i) {
			String s=br.readLine();
			for(int j=0; j<C;++j) {
				col[j][i] = j;
				if(s.charAt(j)=='X'&&top[j]==R) {
					top[j]=i;
				}
				map[i][j]=s.charAt(j);
			}
		}
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			int c=Integer.parseInt(br.readLine())-1;
			int r=top[c]-1;
			map[r][col[c][r]]='O';
			for(int j=0;j<C;++j) {
				while(true) {
					r = top[j];
					c = col[j][r - 1];
					if(r > 1 && map[r - 1][c] != '.') {
						top[j]--;
						continue;
					}
					if(r == R || map[r][c] == 'X') {	//맨 아래이거나 X일때는 신경쓰지 않는다.
						break;
					} else if(map[r][c] == '.') {
						col[j][r] = c;
						top[j]++;
					} else if(c > 0 && map[r][c - 1] == '.' && map[r - 1][c - 1] == '.') {	//왼쪽 체크
						col[j][r] = c - 1;
						top[j]++;
					} else if(c < C - 1 && map[r][c + 1] == '.' && map[r - 1][c + 1] == '.') {	//오른쪽 체크
						col[j][r] = c + 1;
						top[j]++;
					} else {
						break;
					}
				}
			}
		}
		for(int i=0; i<R;++i) {
			for(int j=0; j<C;++j) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}