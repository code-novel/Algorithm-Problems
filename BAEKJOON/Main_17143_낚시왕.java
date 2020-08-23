import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17143_낚시왕{
	public static int R, C, M;
	public static int bada[][];
	public static HashMap<Integer, int[]> map=new HashMap<Integer, int[]>();//배열은 순서대로 r, c,s(속력),d(방향)z(크기)
	public static int score=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		bada=new int[R+1][C+1];
		for(int i=1;i<=M;++i) {
			st=new StringTokenizer(br.readLine());
			map.put(i, new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		int [][]tmpMap=new int[R+1][C+1];
		for(int i=1;i<=M;++i) {
			int su[]=map.get(i);
			tmpMap[su[0]][su[1]]=i;
		}
		for(int j=1;j<=R;++j) {
			if(tmpMap[j][1]!=0) {
				int su[]=map.get(tmpMap[j][1]);
				score+=su[4];
				map.remove(tmpMap[j][1]);
				break;
			}
		}
		for(int i=2;i<=C;++i) {
			tmpMap=move();
			for(int j=1;j<=R;++j) {
				if(tmpMap[j][i]!=0) {
					int su[]=map.get(tmpMap[j][i]);
					score+=su[4];
					map.remove(tmpMap[j][i]);
					break;
				}
			}
		}
		System.out.println(score);
	}
	public static int[][] move() {
		int[][] tmpMap=new int[R+1][C+1];
		for(int i=1;i<=M;++i) {
			if(!map.containsKey(i))continue;
			else {
				int []su=map.get(i);
				if(su[3]==1) { //위
					int s=su[2];
					s%=2*(R-1);
					if(su[0]>s) {
						su[0]-=s;
					}else {
						s-=su[0]-1;
						if(s<R) {
							su[0]=s+1;
							su[3]=2;
						}else {
							su[0]=2*R-s-1;
						}
					}
				}else if(su[3]==2) { //아래
					int s=su[2];
					s%=2*(R-1);
					if(su[0]+s<=R) {
						su[0]+=s;
					}else {
						s-=R-su[0];
						if(s<R) {
							su[0]=R-s;
							su[3]=1;
						}else {
							su[0]=s-R+2;
						}
					}
				}else if(su[3]==3) { //오른쪽
					int s=su[2];
					s%=2*(C-1);
					if(su[1]+s<=C) {
						su[1]+=s;
					}else {
						s-=C-su[1];
						if(s<C) {
							su[1]=C-s;
							su[3]=4;
						}else {
							su[1]=s-C+2;
						}
					}
				}else if(su[3]==4) { //왼쪽
					int s=su[2];
					s%=2*(C-1);
					if(su[1]>s) {
						su[1]-=s;
					}else {
						s-=su[1]-1;
						if(s<C) {
							su[1]=s+1;
							su[3]=3;
						}else {
							su[1]=2*C-s-1;
						}
					}
				}
				if(tmpMap[su[0]][su[1]]==0) {
					tmpMap[su[0]][su[1]]=i;
					map.put(i, su);
				}else {
					int[]zzang=map.get(tmpMap[su[0]][su[1]]);
					if(zzang[4]>su[4]) {
						map.remove(i);
					}else {
						map.remove(tmpMap[su[0]][su[1]]);
						tmpMap[su[0]][su[1]]=i;
						map.put(i, su);
					}
				}
			}
		}
		return tmpMap;
	}
}