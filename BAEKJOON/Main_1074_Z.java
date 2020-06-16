import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z{
	public static int N, r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N=Integer.parseInt(st.nextToken());
	    r=Integer.parseInt(st.nextToken());
	    c=Integer.parseInt(st.nextToken());
	    int n = getSize(N);   
	    int count = 0;
        int x = 0;
        int y = 0;
        while(n > 0) {
            n /= 2;
            // 2사분면 (왼 위)
            if(r < x+n && c < y+n) {
                count += n * n * 0;
            }
            // 1사분면 (오른 위)
            else if(r < x+n) {
                count += n * n * 1;
                y += n;
            }
            // 3사분면 (왼 아래)
            else if(c < y+n) {
                count += n * n * 2;
                x += n;
            }
            // 4사분면 (오른 아래)
            else {
                count += n * n * 3;
                x += n;
                y += n;
            }
            if(n == 1) {
                System.out.println(count);
                break;
            }
        }
	}
	static int getSize(int n) {
        int result = 1;
        for(int i=0; i<n; i++)
            result *= 2;
        return result;
    }
}
