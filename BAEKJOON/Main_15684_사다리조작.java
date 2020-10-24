import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15684_사다리조작{
	public static int N, M, H;
	public static int map[][];
	public static int max;
	public static boolean possible=false;
	public static ArrayList<Integer> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		map=new int[H+2][N+1];
		if(M==0) {
			System.out.println(0);
			return;
		}
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1;
		}
		for (int i = 0; i <= 3; i++) {
			max = i;
	        sadari(1,1,0);
	        if(possible) break;
		}
		System.out.println(possible? max : -1);
	}
	public static void sadari(int r, int c, int cnt) {
		if(max==cnt) {
			if(check()) {
				possible=true;
			}
			return;
		}
		for (int i = (c < N ? r : r+1); i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j] == 1 || map[i][j-1] == 1 || map[i][j+1] == 1) continue;
                map[i][j] = 1;
                sadari(i,j,cnt+1);
                map[i][j] = 0;
            }
        }
	}
	public static boolean check() {
		for(int i=1;i<=N;++i) {
			int j=1;
			int tmp=i;
			while(j<=H+1) {
				if(map[j][tmp]==1) {
					tmp++;
				}else if(map[j][tmp-1]==1) {
					tmp--;
				}
				j++;
			}
			if(i!=tmp) {
				return false;
			}
		}
		return true;
	}
}