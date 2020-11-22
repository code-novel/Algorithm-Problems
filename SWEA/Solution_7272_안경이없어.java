import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_7272_안경이없어 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A=st.nextToken();
            String B=st.nextToken();
            String ans="DIFF";
             if(A.length()==B.length()) {
                A=change(A);
                B=change(B);
                if(A.equals(B)) {
                    ans="SAME";
                }
            }
            System.out.println("#"+t+" "+ans);
        }
    }
 
    public static String change(String a) {
        StringBuilder b=new StringBuilder();
        for(int i=0; i<a.length();++i) {
            switch(a.charAt(i)) {
            case 'B': b.append(2);
                break;
            case 'A':
            case 'D':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
                b.append(1);
            break;
            default:
                b.append(0);
            }
        }
        return b.toString();
    }
}