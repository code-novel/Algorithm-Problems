import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;++t) {
			int k=Integer.parseInt(br.readLine());
			TreeMap<Long, Integer> map = new TreeMap<>();
			StringTokenizer st;
			for(int i=0;i<k;++i) {
				st=new StringTokenizer(br.readLine());
				String s=st.nextToken();
				long num=Long.parseLong(st.nextToken());
				if(s.equals("I")) {
					if(map.containsKey(num))
						map.put(num,map.get(num)+1);
					else
						map.put(num, 1);
				}else if(s.equals("D")) {
					if(map.isEmpty()) continue;
					if(num == -1) {
						long min = map.firstKey();
						int cnt = map.get(min)-1;
					if(cnt == 0)
						map.remove(min);
					else
						map.put(min, cnt);
					}
					else if(num == 1) {
						long max = map.lastKey();
						int cnt = map.get(max)-1;
					if(cnt == 0)
						map.remove(max);
					else
						map.put(max, cnt);
					}
				}
			}
			if(map.isEmpty())sb.append("EMPTY\n");
			else {
				sb.append(map.lastKey()+ " " +map.firstKey()+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}