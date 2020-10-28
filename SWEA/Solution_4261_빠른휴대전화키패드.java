import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4261_빠른휴대전화키패드 {
    public static int cnt=0;
    public static String S;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            S=st.nextToken();
            int N=Integer.parseInt(st.nextToken());
            cnt=0;
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;++i) {
                check(st.nextToken());
            }
            System.out.println("#"+t+" "+cnt);
        }
    }
    private static void check(String word) {
        for(int i=0;i<word.length();++i) {
            switch(word.charAt(i)) {
            case 'a':
            case 'b':
            case 'c':
                if(S.charAt(i)!='2')return;
                break;
            case 'd':
            case 'e':
            case 'f':
                if(S.charAt(i)!='3')return;
                break;
            case 'g':
            case 'h':
            case 'i':
                if(S.charAt(i)!='4')return;
                break;
            case 'j':
            case 'k':
            case 'l':
                if(S.charAt(i)!='5')return;
                break;
            case 'm':
            case 'n':
            case 'o':
                if(S.charAt(i)!='6')return;
                break;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                if(S.charAt(i)!='7')return;
                break;
            case 't':
            case 'u':
            case 'v':
                if(S.charAt(i)!='8')return;
                break;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                if(S.charAt(i)!='9')return;
                break;
            }
        }
        cnt++;
    }
}