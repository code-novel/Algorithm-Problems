import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
public class Solution_1233_사칙연산유효성검사 {
    static StringBuilder sb = new StringBuilder();
    static String[] arr;
    static int N;
    public static void inorder(int idx) {
        if(idx>N) return;
        inorder(idx*2);
        sb.append(arr[idx]);
        inorder(idx*2+1);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t <= 10; ++t) {
            int res = 1;
            N = Integer.parseInt(in.readLine());
            arr = new String [N+1];
            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(in.readLine());
                st.nextToken();
                arr[i] = st.nextToken();
            }
            inorder(1);
            String str = sb.toString();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(i%2==0) {
                    if(c-48>=0 && c-48<=9) {
                        continue;
                    }else {
                        res = 0;
                        break;
                    }
                }else {
                    if(c=='+'||c=='-'||c=='*'||c=='/') {
                        continue;
                    }else {
                        res = 0;
                        break;
                    }
                }
            }
            System.out.println("#"+t+" "+res);
            sb.setLength(0);
        }
    }
}