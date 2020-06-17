import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		HashMap<String, Integer> dd=new HashMap<>();
		ArrayList arr= new ArrayList<String>();
		for(int i=1;i<=N;++i) {
			dd.put(br.readLine(), i);
		}
		for(int j=0;j<M;++j) {
			String s=br.readLine();
			if(dd.containsKey(s)) {
				arr.add(s);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for(int i=0;i<arr.size();++i) {
			System.out.println(arr.get(i));
		}
	}

}
