import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution_2105_디저트카페 {
 
    public static int[] dirr= {1,1,-1,-1};
    public static int[] dirc= {1,-1,-1,1};
    public static int[][]map;
    public static int sr=0;
    public static int sc=0;
    public static List<Integer> list;
    public static int ans;
    public static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            int N=Integer.parseInt(br.readLine());
            ans=-1;
            map=new int[N+2][N+2];
            list=new ArrayList<Integer>();
            StringTokenizer st;
            for(int i=1;i<=N;++i) {
                st=new StringTokenizer(br.readLine());
                for(int j=1;j<=N;++j) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            for(int i=1;i<N;++i) {
                for(int j=2;j<=N;++j) {
                    isVisited=new boolean[N+2][N+2];
                    sr=i; sc=j;
                    isVisited[i][j]=true;
                    list.add(map[i][j]);
                    dfs(i,j,0,0);
                    list.clear();
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }
    private static void dfs(int r, int c, int d, int cnt) {
        for(int i=d;i<4;++i) {
            int nr=r+dirr[i];
            int nc=c+dirc[i];
            if(i==d+1)cnt++;
            if(map[nr][nc]!=0&&!isVisited[nr][nc]) {
                boolean chk=list.contains(map[nr][nc]);
                if(chk)continue;
                else {
                    isVisited[nr][nc]=true;
                    list.add(map[nr][nc]);
                    dfs(nr,nc,i,cnt);
                    list.remove(list.size()-1);
                    isVisited[nr][nc]=false;
                }
            }
            if(cnt==3&&nr==sr&&nc==sc) {
                int tmp=list.size();
                if(ans<tmp)ans=tmp;
                return;
            }
        }
    }
 
}