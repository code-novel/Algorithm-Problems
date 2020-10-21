import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20061_모노미노도미노2{
	public static int N, t, x, y;
	public static int score=0, block=0;
	public static int[][] map1=new int[6][4], map2=new int[6][4];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0;tc<N;++tc) {
			st=new StringTokenizer(br.readLine());
			t=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			setBlock(t,x,y);
			getScore(map1);
			getScore(map2);
			setLine(map1);
			setLine(map2);
		}
		for(int i=0;i<6;++i) {
			for(int j=0;j<4;++j) {
				if(map1[i][j]!=0)++block;
				if(map2[i][j]!=0)++block;
			}
		}
		System.out.println(score);
		System.out.println(block);
	}
	public static void setLine(int [][]map) {
		int line=0;
		for(int i=0;i<2;++i) {
			boolean hasBlock=false;
			for(int j=0;j<4;++j) {
				if(map[i][j]!=0) {
					hasBlock=true;
					break;
				}
			}
			if(hasBlock) {
				line++;
			}
		}
		if(line==1) {
			for(int i=4;i>0;--i) {
				for(int j=0;j<4;++j) {
					map[i+1][j]=map[i][j];
				}
			}
			Arrays.fill(map[1], 0);
		}else if(line==2) {
			for(int i=3;i>-1;--i) {
				for(int j=0;j<4;++j) {
					map[i+2][j]=map[i][j];
				}
			}
			Arrays.fill(map[1], 0);
			Arrays.fill(map[0], 0);
		}
	}
	public static void getScore(int [][]map) {
		int line=0;
		boolean[] isNotLine=new boolean[6];
		for(int i=0;i<6;++i) {
			for(int j=0;j<4;++j) {
				if(map[i][j]==0) {
					isNotLine[i]=true;
					break;
				}
			}
		}
		for(int i=5;i>-1;--i) {
			if(!isNotLine[i]) {
				line++;
				score++;
				Arrays.fill(map[i], 0);
			}else {
				map[i+line]=map[i].clone();
			}
		}
	}
	public static void setBlock(int tt, int xx, int yy) {
		int idx;
		switch(tt) {
		case 1:
			idx=1;
			while(idx<5&&map1[idx+1][y]==0) idx++;
			map1[idx][y]=1;
			idx=1;
			while(idx<5&&map2[idx+1][3-x]==0) idx++;
			map2[idx][3-x]=1;
			break;
		case 2:
			idx=1;
			while(idx<5&&map1[idx+1][y]==0&&map1[idx+1][y+1]==0) idx++;
			map1[idx][y]=1;
			map1[idx][y+1]=1;
			idx=1;
			while(idx<5&&map2[idx+1][3-x]==0) idx++;
			map2[idx-1][3-x]=1;
			map2[idx][3-x]=1;
			 break;
		case 3:
			idx=1;
			while(idx<5&&map1[idx+1][y]==0) idx++;
			map1[idx][y]=1;
			map1[idx-1][y]=1;
			idx=1;
			while(idx<5&&map2[idx+1][3-x]==0&&map2[idx+1][2-x]==0) idx++;
			map2[idx][2-x]=1;
			map2[idx][3-x]=1;
			 break;
		}
	}
}