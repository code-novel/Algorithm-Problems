import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620_꽃길{
    public static int N;
    public static int map[][];
    public static int min=9999;
    public static int dx[]={0,0,0,-1,1};
    public static int dy[]={0,1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check(0,0,0);
        System.out.println(min);
    }
    public static int planting(int r, int c){
        int score=0;
        for(int i=0;i<5;++i){
            int nr=r+dx[i];
            int nc=c+dy[i];
            score+=map[nr][nc];
            map[nr][nc]+=9999;
        }
       return score;
    }
    public static void reset(int r, int c){
        for(int i=0;i<5;++i){
            int nr=r+dx[i];
            int nc=c+dy[i];
            map[nr][nc]-=9999;
        }
    }
    public static void check(int pos ,int flower,int sum){
        if(pos>=(N-2)*(N-2)&&flower<3)return;
        int r=1+pos/(N-2);
        int c=1+pos%(N-2);
        if(flower==3) {
            if (min > sum) min = sum;
            return;
        }
        check(pos+1,flower+1,sum+planting(r,c));
        reset(r,c);
        check(pos+1,flower,sum);
    }
}