import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18235_모노미노도미노{
	public static int N, t, x, y;
	public static int score=0, block=0;
	public static int[] type;
	public static int[][] map1=new int[6][4], map2=new int[6][4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		type=new int[N+1];
		StringTokenizer st;
		for(int tc=0;tc<N;++tc) {
			st=new StringTokenizer(br.readLine());
			t=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			type[tc+1]=t;
			setBlock(tc+1,t,x,y);
			getScore(map1, 2);
			getScore(map2, 3);
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
	public static void getScore(int [][]map, int tt) {
		boolean noLine=false;
		int max=0;
		while(!noLine) {
			noLine=true;
			boolean[] isNotLine=new boolean[6];
			for(int i=0;i<6;++i) {
				for(int j=0;j<4;++j) {
					if(map[i][j]==0) {
						isNotLine[i]=true;
						break;
					}
				}
			}
			for(int i=0;i<6;++i) {
				if(!isNotLine[i]) {
					noLine=false;
					max=Math.max(max, i);
					Arrays.fill(map[i], 0);
					score++;
				}
			}
			if(!noLine) {
				for(int j=max;j>-1;--j) {
					for(int k=0;k<4;++k) {
						if(map[j][k]!=0) {
							if(type[map[j][k]]==tt) {
								int idx=j;
								while(idx<5&&map[idx+1][k]==0&&map[idx+1][k+1]==0) {
									idx++;
								}
								map[idx][k]=map[j][k];
								map[idx][k+1]=map[j][k+1];
								map[j][k]=0;
								map[j][k+1]=0;
							}else {
								int idx=j;
								while(idx<5&&map[idx+1][k]==0) {
									idx++;
								}
								map[idx][k]=map[j][k];
								map[j][k]=0;
							}
						}
					}
				}
			}
		}
	}
	public static void setBlock(int i, int tt, int xx, int yy) {
		int idx;
		switch(tt) {
		case 1:
			idx=1;
			while(idx<5&&map1[idx+1][y]==0) idx++;
			map1[idx][y]=i;
			idx=1;
			while(idx<5&&map2[idx+1][3-x]==0) idx++;
			map2[idx][3-x]=i;
			break;
		case 2:
			idx=1;
			while(idx<5&&map1[idx+1][y]==0&&map1[idx+1][y+1]==0) idx++;
			map1[idx][y]=i;
			map1[idx][y+1]=i;
			idx=1;
			while(idx<5&&map2[idx+1][3-x]==0) idx++;
			map2[idx-1][3-x]=i;
			map2[idx][3-x]=i;
			 break;
		case 3:
			idx=1;
			while(idx<5&&map1[idx+1][y]==0) idx++;
			map1[idx][y]=i;
			map1[idx-1][y]=i;
			idx=1;
			while(idx<5&&map2[idx+1][3-x]==0&&map2[idx+1][2-x]==0) idx++;
			map2[idx][2-x]=i;
			map2[idx][3-x]=i;
			 break;
		}
	}
}