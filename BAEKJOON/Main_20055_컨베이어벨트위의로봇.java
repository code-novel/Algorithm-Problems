import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {
	public static int N, K;
	public static int zero=0;
	public static int[] A;
	public static boolean robot[];
	public static int start, end;
	public static int step;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		A=new int[2*N];
		robot=new boolean[2*N];
		for(int i=0;i<2*N;++i) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		start=0;
		end=N-1;
		step=0;
		while(zero<K) {
			moveC();
			moveRobot();
			setRobot();
			step++;
		}
		System.out.println(step);
	}
	public static void setRobot() {
		if(!robot[start]&&A[start]!=0) {
			robot[start]=true;
			A[start]--;
			if(A[start]==0) zero++;
		}
	}
	public static void moveRobot() {
		if(start>end) {
			for(int i=end-1;i>-1;--i) {
				if(!robot[i])continue;
				if(!robot[i+1]&&A[i+1]!=0) {
					robot[i]=false;
					robot[i+1]=true;
					A[i+1]--;
					if(A[i+1]==0) zero++;
				}
			}
			if(robot[2*N-1]&&!robot[0]&&A[0]!=0) {
				robot[2*N-1]=false;
				robot[0]=true;
				A[0]--;
				if(A[0]==0) zero++;
			}
			for(int i=2*N-2;i>start;--i) {
				if(!robot[i])continue;
				if(!robot[i+1]&&A[i+1]!=0) {
					robot[i]=false;
					robot[i+1]=true;
					A[i+1]--;
					if(A[i+1]==0) zero++;
				}
			}
		}else {
			for(int i=end-1;i>start;--i) {
				if(!robot[i])continue;
				if(!robot[i+1]&&A[i+1]!=0) {
					robot[i]=false;
					robot[i+1]=true;
					A[i+1]--;
					if(A[i+1]==0) zero++;
				}
			}
		}
		if(robot[end]==true) robot[end]=false;
	}
	public static void moveC() {
		if(start==0) start=2*N-1;
		else start--;
		if(end==0) end=2*N-1;
		else end--;
		if(robot[end]==true) robot[end]=false;
	}
}