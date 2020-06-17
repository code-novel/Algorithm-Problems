import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		HashMap<String, Integer> mon = new HashMap();
		HashMap<Integer, String> num = new HashMap();
		for(int i=1;i<=N;++i) {
			String s=br.readLine();
			mon.put(s, i);
			num.put(i, s);
		}
		for(int i=0;i<M;++i) {
			String s=br.readLine();
			if(s.charAt(0)<='9') {
				System.out.println(num.get(Integer.parseInt(s)));
			}else {
				System.out.println(mon.get(s));
			}
		}
	}

}
