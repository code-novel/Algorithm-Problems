import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18228_펭귄추락대책위원회 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
		int cnt=0;
		for(int i=0;i<N;++i) {
			int num=Integer.parseInt(st.nextToken());
			if(num!=-1) {
				cnt++;
				min1=min1>num?num:min1;
			}else {
				break;
			}
		}
		for(int i=cnt+1;i<N;++i) {
			int num=Integer.parseInt(st.nextToken());
			min2=min2>num?num:min2;
		}
		if(min1==Integer.MAX_VALUE)min1=0;
		if(min2==Integer.MAX_VALUE)min1=0;
		System.out.println(min1+min2);
	}

}
