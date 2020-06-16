import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[]arr=new int[N+1];
        int idx=1;
        int cnt=0;
	    while(true) {
	    	arr[idx]++;
	    	if(arr[idx]==M)break;
	    	if(arr[idx]%2==0) {
	    		idx-=L;
	    		if(idx<1) idx+=N;
	    	}else {
	    		idx+=L;
	    		if(idx>N) idx-=N;
	    	}
	    	cnt++;
	    }
        System.out.println(cnt);
	}
}