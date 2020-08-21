import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이{
	public static int dice[]=new int[10];
	public static int[][]map={{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},{10,13,16,19},{20,22,24,25,30,35,40,0},{30,28,27,26}};
	public static int[][]mal=new int[5][2];
	public static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<10;++i) {
			dice[i]=Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		System.out.println(max);
	}
	public static void dfs(int idx,int score) {
		if(idx==10) {
			max=Math.max(max, score);
		}else {
			for(int i=0;i<5;++i) {
				if(mal[i][0]==2&&mal[i][1]==7)continue;
				int tmpMal[]=new int [2];
				tmpMal[0]=mal[i][0];
				tmpMal[1]=mal[i][1];
				int tmp=move(dice[idx],i);
				if(tmp==-1) continue;
				dfs(idx+1,score+tmp);
				mal[i][0]=tmpMal[0];
				mal[i][1]=tmpMal[1];
			}
		}
	}
	public static int move(int dice, int sel) {
		int tmpR=mal[sel][0];
		int tmpC=mal[sel][1]+dice;
		if(tmpR==0) {
			if(tmpC==5) {
				tmpR=1;tmpC=0;
			}else if(tmpC==10) {
				tmpR=2;tmpC=0;
			}else if(tmpC==15) {
				tmpR=3;tmpC=0;
			}else if(tmpC==20) {
				tmpR=2;tmpC=6;
			}else if(tmpC>20) {
				tmpR=2; tmpC=7;
			}
		}else if(tmpR==1) {
			if(tmpC>=map[1].length) {
				tmpR=2;tmpC=3+tmpC-4;
			}
		}else if(tmpR==2) {
			if(tmpC>=map[2].length) {
				tmpC=7;
			}
		}else if(tmpR==3) {
			if(tmpC>=map[3].length) {
				tmpR=2;tmpC=3+tmpC-4;
			}
		}
		for(int i=0;i<5;++i) {
			if(i==sel)continue;
			else {
				if(tmpR==mal[i][0]&&tmpC==mal[i][1]&&!(tmpR==2&&tmpC==7)) {
					return -1;
				}
			}
		}
		mal[sel][0]=tmpR;
		mal[sel][1]=tmpC;
		return map[tmpR][tmpC];
	}
}