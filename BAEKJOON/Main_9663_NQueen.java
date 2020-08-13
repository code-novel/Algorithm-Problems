import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_9663_NQueen {
	public static int N;
	public static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		int []visited=new int[N+1];
		Arrays.fill(visited,-1);
		nq(1,visited);
		System.out.println(cnt);
	}
	public static void nq(int idx, int [] visited) {
		if(idx==N+1) {
			cnt++;
		}else {
			for(int i=1;i<=N;++i) {
				boolean isPossible=true;
				for(int j=1;j<idx;++j) {
					if(visited[j]==i)isPossible=false;
					else if(Math.abs(idx-j)==Math.abs(i-visited[j]))isPossible=false;
				}
				if(isPossible) {
					visited[idx]=i;
					nq(idx+1,visited);
					visited[idx]=-1;
				}
			}
		}
	}
}