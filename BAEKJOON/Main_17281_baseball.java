import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_baseball {
	public static int N;
	public static int taja[][];
	public static int max=0;
	public static boolean[]base;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		taja=new int[N+1][10];
		StringTokenizer st;
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=9;++j) {
				taja[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		boolean []check=new boolean[10];
		int[] tasoon=new int[10];
		tasoon[4]=1;
		permutation(1,tasoon, check);
		System.out.println(max);
	}
	public static void permutation(int idx,int[] tasoon, boolean[]check) {
		if(idx==10) {
			int now=1;
			int score=0;
			for(int i=1;i<=N;++i) {
				int out=0;
				base=new boolean [8];
				while(out<3) {
					int anta=taja[i][tasoon[now]];
					if(anta==0) out++;
					else {
						base[0]=true;
						score+=calculation(anta);
					}
					if(now!=9) now++;
					else now=1;
				}
			}
			max=Math.max(max, score);
		}else if(idx==4){
			permutation(idx+1,tasoon,check);
		}else {
			for(int i=2;i<=9;++i) {
				if(!check[i]) {
					check[i]=true;
					tasoon[idx]=i;
					permutation(idx+1,tasoon,check);
					check[i]=false;
				}
			}
		}
	}
	public static int calculation(int roota) {
		int score=0;
		for(int i=3;i>-1;--i) {
			if(base[i]) {
				base[i+roota]=base[i];
				base[i]=false;
			}
		}for(int i=4;i<=7;++i) {
			if(base[i]) {
				score++;
				base[i]=false;
			}
		}
		return score;
	}
}