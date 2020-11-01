import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_5672_올해의조련사 {
    public static char[] sae;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            int N=Integer.parseInt(br.readLine());
            sae=new char[N];
            for(int i=0;i<N;++i) {
                sae[i]=br.readLine().charAt(0);
            }
            StringBuilder sb=new StringBuilder();
            int start=0; int end=N-1;
            for(int i=0;i<N;i++){
                if(sae[start]>sae[end]) {
                    sb.append(sae[end]);
                    end--;
                }else if(sae[start]<sae[end]) {
                    sb.append(sae[start]);
                    start++;
                }else {
                    int tmpstart=start+1;
                    int tmpend=end-1;
                    while(true) {
                        if(tmpend>tmpstart) {
                            if(sae[tmpstart]<sae[tmpend]) {
                                sb.append(sae[start]);
                                start++;
                                break;
                            }else if(sae[tmpstart]>sae[tmpend]) {
                                sb.append(sae[end]);
                                end--;
                                break;
                            }else if(sae[tmpstart]==sae[tmpend]) {
                                tmpend--;
                                tmpstart++;
                            }
                        }else {
                            sb.append(sae[start]);
                            start++;
                            break;
                        }
                    }
                }
            }
             
            System.out.println("#"+t+" "+sb.toString());
            sb.setLength(0);
        }
    }
 
}