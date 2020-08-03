import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		boolean[] hap=new boolean[21];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;++i) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String s=st.nextToken();
			if(s.equals("empty")) {
				hap=new boolean[21];
			}else if(s.equals("all")) {
				for(int j=1;j<=20;++j) {
					hap[j]=true;
				}
			}else {
				int num=Integer.parseInt(st.nextToken());
				if(s.equals("add")) {
					hap[num]=true;
				}else if(s.equals("remove")) {
					hap[num]=false;
				}else if(s.equals("check")) {
					if(hap[num]) {
						sb.append(1+"\n");
					}else {
						sb.append(0+"\n");
					}
				}else if(s.equals("toggle")) {
					if(hap[num]) {
						hap[num]=false;
					}else {
						hap[num]=true;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}