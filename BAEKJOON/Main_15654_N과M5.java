import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {
	public static int[] num;
	public static int N, M;
	public static int[] res;
	static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		num=new int[N];
		res=new int[M];
		isSelected = new boolean[N];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;++i) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		permutation(0);
	}
	public static void permutation(int index) {
		if(index == M) {
			for(int i=0;i<M;++i)
				System.out.print(res[i]+" ");
			System.out.println();
			return;
		}
		for (int i = 0; i <N ; ++i) {
			if(!isSelected[i]) { // 해당수가 선택되지 않았다면
				res[index] = num[i];
				isSelected[i] = true; // 현재 선택한수 사용한 플래그 처리
				permutation(index+1);
				isSelected[i]= false;
			}
		}
	}

}
