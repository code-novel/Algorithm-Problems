import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String password=br.readLine();
        StringBuilder sb=new StringBuilder();
        char[][]map;
        int N=password.length();
        int R=0, C=0;
        for(int i=1;i<N/2;++i) {
        	if(N%i==0&&i<=N/i&&R<i) {
        		R=i;
        		C=N/i;
        	}
        }
        map=new char[C][R];
        int idx=0;
        for(int i=0;i<C;++i) {
        	for(int j=0; j<R;++j) {
        		map[i][j]=password.charAt(idx++);
        	}
        }
        for(int i=0;i<R;++i) {
        	for(int j=0; j<C;++j) {
        		sb.append(map[j][i]);
        	}
        }
        System.out.println(sb.toString());
	}
}