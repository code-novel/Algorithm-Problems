import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2573_빙산{
    public static int N, M;
    public static int [][]map;
    public static int [][]map2;
    public static boolean [][]isVisited;
    public static boolean isNotNull;
    public static int[] dx={-1,1,0,0};
    public static int[] dy={0,0,-1,1};
    public static int BHcnt;
    public static int year=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+2][M+2];
        map2=new int[N+2][M+2];
        isVisited=new boolean[N+2][M+2];
        for(int i=0;i<N+2;++i){
            Arrays.fill(map[i],-1);
        }
        for(int i=1;i<=N;++i){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=M;++j){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        out:
        while(true){
            boolean isNotNull=false;
            BHcnt=0;
            isVisited=new boolean[N+2][M+2];
            year++;
            for(int i=1;i<=N;++i){
                for(int j=1; j<=M;++j){
                    if(map[i][j]!=0){
                        melting(i, j);
                    }
                }
            }
            sum();
            for(int i=1;i<=N;++i){
                for(int j=1; j<=M;++j){
                    if(map[i][j]!=0&&!isVisited[i][j]){
                    	isNotNull=true;
                        BHcnt++;
                        if(BHcnt>1)break out;
                        dfs(i, j);
                    }
                }
            }
            if(!isNotNull){
                year=0;
                break;
            }
            
        }
        System.out.println(year);
    }
    public static void melting(int r, int c){
        int amount=0;
        for(int i=0;i<4;++i){
            int nx=r+dx[i];
            int ny=c+dy[i];
            if(map[nx][ny]==0){
                amount++;
            }
        }
        map2[r][c]=amount;
    }
    public static void sum() {
    	for(int i=1;i<=N;++i){
            for(int j=1; j<=M;++j){
                map[i][j]=map[i][j]-map2[i][j];
                map2[i][j]=0;
                if(map[i][j]<0)map[i][j]=0;
            }
        }
    }
    public static void dfs(int r, int c){
        isVisited[r][c]=true;
        for(int i=0;i<4;++i){
            int nx=r+dx[i];
            int ny=c+dy[i];
            if(map[nx][ny]>0&&!isVisited[nx][ny]){
               dfs(nx,ny);
            }
        }
    }
}