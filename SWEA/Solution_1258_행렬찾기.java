import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution_1258_행렬찾기 {
    public static int map[][];
    public static boolean isVisited[][];
    public static int maxrow=1, maxcol=1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            int N=Integer.parseInt(br.readLine());
            int cnt=0;      //행렬의 개수
            List<int[]> set=new ArrayList<int[]>();
            StringTokenizer st;
            map=new int[N+2][N+2];
            isVisited=new boolean[N+2][N+2];
 
            for(int i=1; i<=N;++i) {
                st=new StringTokenizer(br.readLine());
                for(int j=1; j<=N;++j) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=1; i<=N;++i) {
                for(int j=1; j<=N;++j) {
                    if(!isVisited[i][j]&&map[i][j]!=0) {
                        maxrow=1; maxcol=1;
                        isVisited[i][j]=true;
                        cnt++;
                        dfs(i,j,1,1);
                        set.add(new int[]{maxrow,maxcol});
                    }
                }
            }
            Collections.sort(set,new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    int result;
                     if ( o1[0]*o1[1]>o2[0]*o2[1]) {
                            result = 1;
                        } else if (o1[0]*o1[1]<o2[0]*o2[1]) {
                            result = -1;
                        }
                        else  {
                            result = o1[0]-o2[0];
                        }
                    return result;
                }
            });
             
            System.out.print("#"+t+" "+cnt+" ");
            for(int i=0;i<set.size();++i) {
                System.out.print(set.get(i)[0]+" "+set.get(i)[1]+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int r, int c, int row, int col) {
        int nr=r+1;
        int nc=c+1;
        if(!isVisited[r][nc]&&map[r][nc]!=0) {
            isVisited[r][nc]=true;
            col++;
            if(maxcol<col)maxcol=col;
            dfs(r,nc,row, col);
        }
        if(!isVisited[nr][c]&&map[nr][c]!=0) {
            isVisited[nr][c]=true;
            row++;
            if(maxrow<row)maxrow=row;
            dfs(nr,c,row, col);
        }
    }
 
}