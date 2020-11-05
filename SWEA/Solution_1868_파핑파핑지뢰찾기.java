import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_1868_파핑파핑지뢰찾기 {
    public static char [][]map;
    public static int[] dirr= {-1,-1,-1,0,0,1,1,1};
    public static int[] dirc= {-1,0,1,-1,1,-1,0,1};
    public static boolean[][] isVisited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            int N=Integer.parseInt(br.readLine());
            map=new char[N+2][N+2];
            isVisited=new boolean[N+2][N+2];
            for(int i=1;i<=N;++i) {
                String s=br.readLine();
                for(int j=1;j<=N;++j) {
                    map[i][j]=s.charAt(j-1);
                }
            }
            int cnt=0;
            for(int i=1;i<=N;++i) {
                for(int j=1;j<=N;++j) {
                    if(map[i][j]=='.') {
                        boolean chk=false;
                        for(int k=0;k<8;++k) {
                            int nr=i+dirr[k];
                            int nc=j+dirc[k];
                            if(map[nr][nc]=='*') {
                                chk=true;
                                break;
                            }
                        }
                        if(!chk) {
                            cnt++;
                            dfs(i,j);
                        }
                    }
                }
            }
            for(int i=1;i<=N;++i) {
                for(int j=1;j<=N;++j) {
                    if(map[i][j]=='.') {
                        cnt++;
                        chkstar(i,j);
                    }
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
    public static void dfs(int r, int c) {
        isVisited[r][c]=true;
        chkstar(r,c);
        for(int i=0;i<8;++i) {
            int nr=r+dirr[i];
            int nc=c+dirc[i];
            if(map[nr][nc]!='\0'&&map[nr][nc]!='*')
                chkstar(nr,nc);
            if(map[nr][nc]=='0'&&!isVisited[nr][nc]) {
                dfs(nr,nc);
            }
        }
    }
    public static void chkstar(int r, int c) {
        int starcnt=0;
        for(int i=0;i<8;++i) {
            int nr=r+dirr[i];
            int nc=c+dirc[i];
            if(map[nr][nc]=='*') {
                starcnt++;
            }
        }
        map[r][c]=(char)(starcnt+'0');
    }
}