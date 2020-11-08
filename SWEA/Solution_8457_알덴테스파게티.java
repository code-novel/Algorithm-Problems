import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_8457_알덴테스파게티 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            int []x=new int[N];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;++i) {
                x[i]=Integer.parseInt(st.nextToken());
            }
            int cnt=0;
            for(int i=0;i<N;++i) {
                if(x[i]<B-E) {
                    int moks=B/x[i];
                    if((x[i]*moks>=B-E&&x[i]*moks<=B+E)||(x[i]*(moks+1)>=B-E&&x[i]*(moks+1)<=B+E)) {
                        cnt++;
                    }
                }else if(x[i]<=B+E){
                    cnt++;
                }
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
}