import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_1244_최대상금 {
    static int N;
    static int []arr;
    static int ans=0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            arr= new int[tmp.length()];
            N= Integer.parseInt(st.nextToken());
            for(int i=0;i<tmp.length();++i) {
                arr[i]=(int)tmp.charAt(i)-48;
            }
            permutation(0,0);
             
            System.out.println("#"+t+" "+ans);
            ans=0;
        }
    }
    private static void permutation(int cnt, int fix) {
        if(cnt== N) {
            int tmp = makeInt();
            if(tmp>ans)
                ans=tmp;
            return;
        }
        for (int i =fix; i<arr.length-1;++i) {
            for(int j=i+1; j<arr.length;++j) {
                if(arr[i]<=arr[j]) {
                    swap(i,j);
                    permutation(cnt+1,i);
                    swap(i,j);
                }
            }
        }
    }
    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
    private static int makeInt() {
        int a=0;
        for(int i=0; i<arr.length;++i) {
            a+=arr[i]*(int)Math.pow(10, arr.length-(i+1));
        }
        return a;
    }
 
}