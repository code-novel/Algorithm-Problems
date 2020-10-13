import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_19554_바나나킥을잡아라{
	public static int N, M, X;
	public static HashMap<Integer, Banana> map=new HashMap<>();
	public static int maxIdx=0;
	public static int max=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		for(int i=0;i<X;++i) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			int num=getNum(r,c,d);
			if(i==0) maxIdx=num;
			if(map.containsKey(num)) {
				map.put(num, new Banana(map.get(num).num+1,Math.max(map.get(num).index, r-1)));
				if(max<map.get(num).num) {
					max=map.get(num).num;
					maxIdx=num;
				}else if(max==map.get(num).num) {
					if(map.get(maxIdx).index>map.get(num).index) {
						maxIdx=num;
					}
				}
			}else {
				map.put(num, new Banana(1, r-1));
				if(max==map.get(num).num) {
					if(map.get(maxIdx).index>map.get(num).index) {
						maxIdx=num;
					}
				}
			}
		}
		System.out.println(max+" "+map.get(maxIdx).index);
	}
	public static int getNum(int r, int c, int d) {
		int time=r-1;	//먹히는 시간. 즉 time만큼 움직임.
		time%=(2*M);		//2M마다 위치가 바뀌기 때문에 2M으로 나눠 줌.(주기)
		if(d==1) {		//처음 시작이 오른쪽으로 이동중일 경우.
			if(c+time<=M) return c+time;
			else if(c+time==M+1) return M;
			else {
				time-=M-c;
				if(time<M) return M-time+1;
				else if(time==M) return 1;
				else return time-M;
			}
		}else {
			if(c-time>0) return c-time;
			else if(c-time==0) return 1;
			else {
				time-=c-1;
				if(time<=M) return time;
				else return 2*M-time+1;
			}
		}
	}
	public static class Banana{
		int num;
		int index;
		public Banana(int n, int i) {
			this.num=n;
			this.index=i;
		}
	}
}