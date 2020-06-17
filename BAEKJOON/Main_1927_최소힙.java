import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927_최소힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<N;++i) {
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				if(q.isEmpty())System.out.println(0);
				else
					System.out.println(q.poll());
			}else {
				q.add(n);
			}
		}
	}
}
