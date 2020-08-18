import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16566_카드게임{
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		boolean[] used=new boolean[M];
		int[] Minsu=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;++i) {
			Minsu[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(Minsu);
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<K;++i) {
			int tmp=Integer.parseInt(st.nextToken());
			int place=Math.abs(Arrays.binarySearch(Minsu, tmp)+1);
			while(used[place]) {
				place++;
			}
			used[place]=true;
			System.out.println(Minsu[place]);
		}
	}
}