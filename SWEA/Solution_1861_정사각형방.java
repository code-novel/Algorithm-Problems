import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_1861_정사각형방 {
    public static int[][]map;
    public static boolean[][]isVisited;
    public static boolean[][]chked;
    public static int max=0;
    public static int dirR[]= {-1, 1, 0, 0};
    public static int dirC[]= {0, 0, 1, -1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            int N=Integer.parseInt(br.readLine());
            map=new int[N+2][N+2];
            isVisited=new boolean[N+2][N+2];
            StringTokenizer st;
            int ans=0;
            int idx=0;
            for(int i=1;i<=N;++i) {
                st=new StringTokenizer(br.readLine());
                for(int j=1;j<=N;++j) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=1;i<=N;++i) {
                for(int j=1;j<=N;++j) {
                    if(!isVisited[i][j]) {
                        dfs(i,j,map[i][j],0);
                        if(ans<max) {ans=max;idx=map[i][j];}
                        else if(ans==max){if(idx>map[i][j])idx=map[i][j];}
                        max=0;
                    }
 
                }
            }
            System.out.println("#"+t+" "+idx+" "+ans);
        }
    }
    public static void dfs(int r, int c, int v, int cnt) {
        isVisited[r][c]=true;
        cnt++;
        if(max<cnt)max=cnt;
        for(int i=0;i<4;++i) {
            int nr=r+dirR[i];
            int nc=c+dirC[i];
            if(map[nr][nc]==v+1) {
                dfs(nr,nc,map[nr][nc],cnt);
            }
        }
    }
}