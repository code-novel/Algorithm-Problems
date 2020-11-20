import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Solution_1240_단순2진암호코드 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            map.put("0001101", 0);
            map.put("0011001", 1);
            map.put("0010011", 2);
            map.put("0111101", 3);
            map.put("0100011", 4);
            map.put("0110001", 5);
            map.put("0101111", 6);
            map.put("0111011", 7);
            map.put("0110111", 8);
            map.put("0001011", 9);
            String tmp;
            String code=null;
            for(int r=0; r<N; r++) {
                tmp = br.readLine();
                if(tmp.contains("1")) {
                    for(int c=M-1; c>=0; --c) {
                        if(tmp.charAt(c)=='1') {
                            code = tmp.substring(c-55, c+1);
                            break;
                        }
                    }
                }
            }
            int res = 0;
            int all = 0;
            int hol = 0, jjak = 0, gum = 0;
            for (int i = 0; i < 8; i++) {
                String elm = code.substring(7*i, 7*i+7);
                if(i==7) {
                    gum = map.get(elm);
                    all += gum;
                    break;
                }
                if(map.get(elm)!=null) {
                    if(i%2==0)hol+= map.get(elm);
                    else jjak += map.get(elm);
                    all+= map.get(elm);
                }else {
                    break;
                }
            }
            res = hol*3 + jjak + gum;
            int ans;
            if(res%10==0) ans = all; 
            else ans = 0;
            System.out.println("#"+t+" "+ans);
        }
    }
}