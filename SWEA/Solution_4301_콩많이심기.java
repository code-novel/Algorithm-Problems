import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4301_콩많이심기 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int [][]map=new int[N][M];
            int cnt=0;
            for(int i=0;i<N;++i) {
                for(int j=0;j<M;++j) {
                    if(map[i][j]==0) {
                        cnt++;
                        if(i+2<N) {
                            map[i+2][j]=-1;
                        }
                        if(j+2<M) {
                            map[i][j+2]=-1;
                        }
                    }
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}