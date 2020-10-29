import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_5658_보물상자비밀번호 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            StringBuilder input=new StringBuilder();
            input.append(br.readLine());
            int M=N/4;
            for(int i=0;i<M;++i) {
                input.append(input.charAt(i));
            }
            int[] kkk=new int[N];
            for(int i=0;i<N;++i) {
                kkk[i]=Integer.parseInt(input.substring(i, i+M), 16);
            }
            Arrays.sort(kkk);
            for(int i=0;i<N-1;++i) { //중복제거
                if(kkk[i]==kkk[i+1]) {
                    kkk[i]=0;
                }
            }
            Arrays.sort(kkk);
            System.out.println("#"+t+" "+kkk[N-K]);
        }
    }
}