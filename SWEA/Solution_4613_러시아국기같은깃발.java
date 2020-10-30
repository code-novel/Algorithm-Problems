import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4613_러시아국기같은깃발 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int [][]check=new int[N][3];
            for(int i=0;i<N;++i) {
                String tmp=br.readLine();
                for(int j=0;j<M;++j) {
                    if(tmp.charAt(j)=='W')check[i][0]++;
                    else if(tmp.charAt(j)=='B')check[i][1]++;
                    else if(tmp.charAt(j)=='R')check[i][2]++;
                }
            }
            int min=Integer.MAX_VALUE;
            for(int i=1; i<N-1;++i) {
                for(int j=1; j<N-i;++j) {
                    int temp=0;
                    for(int k=1;k<j;++k) {
                        temp+=M-check[k][0];
                    }
                    for(int k=j;k<j+i;++k) {
                        temp+=M-check[k][1];
                    }
                    for(int k=j+i;k<N-1;++k) {
                        temp+=M-check[k][2];
                    }
                    if(min>temp)min=temp;
                }
            }
            min+=M-check[0][0];
            min+=M-check[N-1][2];
            System.out.println("#"+t+" "+min);
        }
    }
 
}