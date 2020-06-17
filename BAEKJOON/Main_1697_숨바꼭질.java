import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	public static boolean isVisit[]= new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Queue<Integer> q=new LinkedList();
		q.add(N);
		int lv=0;
		out:
		while(N!=K) {
			lv++;
			int q_size=q.size();
			for(int i=0;i<q_size;++i) {
				int now=q.poll();
				if(now*2!=K) {
					if(check(now*2)) {q.add(now*2);isVisit[now*2]=true;}
				}
				else break out;
				if(now-1!=K){
					if(check(now-1)) {q.add(now-1);isVisit[now-1]=true;}
				}
				else break out;
				if(now+1!=K){
					if(check(now+1)) {q.add(now+1);isVisit[now+1]=true;}
				}
				else break out;
			}
		}
		System.out.println(lv);
	}
	private static boolean check(int i) {
        if(i < 0 || i > 100000) return false;
        if(isVisit[i]) return false;
        else return true;
    }
}
