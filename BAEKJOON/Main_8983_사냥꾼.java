import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_8983_사냥꾼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<int[]> list = new ArrayList<int[]>();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int sadae[] = new int[M];
		for (int i = 0; i < M; ++i) {
			sadae[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sadae);
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		Collections.sort(list,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		int cnt=0;
		int j=0;
		for(int i=0;i<list.size();++i) {
			if(sadae[0]>list.get(i)[0]) {		//모든 사대보다 동물이 왼쪽
				if(L-sadae[0]+list.get(i)[0]>=list.get(i)[1])cnt++;
			}else if(sadae[M-1]<list.get(i)[0]) {		//모든 사대보다 동물이 오른쪽에 있으면
				if(L+sadae[M-1]-list.get(i)[0]>=list.get(i)[1])cnt++;
			}else {			//사대들 사이에 있는 동물들
				while(j<M-1&&sadae[j+1]<list.get(i)[0]) {        //j랑 j+1사이에 동물이 위치하게 만든다.
					j++;
				}
				if(j==M-1) {                                    //j가 마지막 값일 경우
					if(L+sadae[j]-list.get(i)[0]>=list.get(i)[1])cnt++;
				}
				else if(sadae[j]==list.get(i)[0]) {            //j랑 동물의 x좌표가 같을 경우(j+1보다 작음)
					if(list.get(i)[1]<=L)cnt++;
				}    //j랑 j+1사이에 동물이 있을경우
				else if((L-sadae[j+1]+list.get(i)[0]>=list.get(i)[1])||(L+sadae[j]-list.get(i)[0]>=list.get(i)[1]))cnt++;
			}
		}
		System.out.println(cnt);
	}
}
