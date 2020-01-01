import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {
	public static int map[][]=new int[10][10];
	public static int min=100;
	public static int max[]=new int[6];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<10; ++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(min==100?-1:min);
	}
	
	public static void dfs(int idx, int cnt) {
        if(idx == 100) {
            min = Math.min(min, cnt);
            return;
        }
        int r = idx/10;
        int c = idx%10;
        
        if(min <= cnt) return;
        
        if(map[r][c] == 1) {
            for(int i=5; i>0; i--) {
                if(max[i] < 5) {
                    if(check(i, r, c)) {
                        change(i, r, c, 0);
                        max[i]++;
                        dfs(idx+1, cnt+1);
                        change(i, r, c, 1);
                        max[i]--;
                    }
                }
            }
        } else dfs(idx+1, cnt);
    }
	
	public static boolean check(int a,int r, int c) {
		if(a+r>10||a+c>10)return false;
		for(int i=r;i<r+a;++i) {
			for(int j=c;j<c+a;++j) {
				if(map[i][j]!=1) {
					return false;
				}
			}
		}
		return true;
	}
	public static void change(int a, int r, int c, int b) {
		for(int i=r;i<r+a;++i) {
			for(int j=c;j<c+a;++j) {
				map[i][j]=b;
			}
		}
	}
}
