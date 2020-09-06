import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	public static int N, M;
	public static int dx[]= {0,-1,0,1,0};
	public static int dy[]= {-1,0,1,0,-1};
	public static int min=Integer.MAX_VALUE;
	public static LinkedList<CCTV> list=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int map[][]=new int[N][M];
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>0&&map[i][j]<6) {
					list.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
		check(0, map);
		System.out.println(min);
	}
	public static void check(int idx,int[][] map) {
		if(idx==list.size()) {
			int cnt=0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					if(map[i][j]==0) cnt++;
				}
			}
			min=Math.min(min, cnt);
		}else {
			CCTV cctv=list.get(idx);
			int[][]tmpMap=new int[N][M];
			for(int i=0;i<N;++i) {
				for(int j=0;j<M;++j) {
					tmpMap[i][j]=map[i][j];
				}
			}
			switch(cctv.d) {
			case 1 :
				for(int i=0;i<4;++i) {
					int nr=cctv.r+dx[i];
					int nc=cctv.c+dy[i];
					while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
						if(tmpMap[nr][nc]==0) {
							tmpMap[nr][nc]=7;
						}
						nr+=dx[i];
						nc+=dy[i];
					}
					check(idx+1,tmpMap);
					for(int j=0;j<N;++j) {
						for(int k=0;k<M;++k) {
							tmpMap[j][k]=map[j][k];
						}
					}
				}
				break;
			case 2 :
				for(int i=0;i<2;++i) {
					int nr=cctv.r+dx[i];
					int nc=cctv.c+dy[i];
					while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
						if(tmpMap[nr][nc]==0) {
							tmpMap[nr][nc]=7;
						}
						nr+=dx[i];
						nc+=dy[i];
					}
					nr=cctv.r+dx[i+2];
					nc=cctv.c+dy[i+2];
					while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
						if(tmpMap[nr][nc]==0) {
							tmpMap[nr][nc]=7;
						}
						nr+=dx[i+2];
						nc+=dy[i+2];
					}
					check(idx+1,tmpMap);
					for(int j=0;j<N;++j) {
						for(int k=0;k<M;++k) {
							tmpMap[j][k]=map[j][k];
						}
					}
				}
				break;
			case 3 :
				for(int i=0;i<4;++i) {
					int nr=cctv.r+dx[i];
					int nc=cctv.c+dy[i];
					while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
						if(tmpMap[nr][nc]==0) {
							tmpMap[nr][nc]=7;
						}
						nr+=dx[i];
						nc+=dy[i];
					}
					nr=cctv.r+dx[i+1];
					nc=cctv.c+dy[i+1];
					while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
						if(tmpMap[nr][nc]==0) {
							tmpMap[nr][nc]=7;
						}
						nr+=dx[i+1];
						nc+=dy[i+1];
					}
					check(idx+1,tmpMap);
					for(int j=0;j<N;++j) {
						for(int k=0;k<M;++k) {
							tmpMap[j][k]=map[j][k];
						}
					}
				}
				break;
			case 4 : 
				for(int i=0;i<4;++i) {
					for(int j=0;j<4;++j) {
						if(i!=j) {
							int nr=cctv.r+dx[j];
							int nc=cctv.c+dy[j];
							while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
								if(tmpMap[nr][nc]==0) {
									tmpMap[nr][nc]=7;
								}
								nr+=dx[j];
								nc+=dy[j];
							}
						}
					}
					check(idx+1,tmpMap);
					for(int j=0;j<N;++j) {
						for(int k=0;k<M;++k) {
							tmpMap[j][k]=map[j][k];
						}
					}
				}
				break;
			case 5 :
				for(int i=0;i<4;++i) {
					int nr=cctv.r+dx[i];
					int nc=cctv.c+dy[i];
					while(nr>-1&&nc>-1&&nr<N&&nc<M&&tmpMap[nr][nc]!=6) {
						if(tmpMap[nr][nc]==0) {
							tmpMap[nr][nc]=7;
						}
						nr+=dx[i];
						nc+=dy[i];
					}
				}
				check(idx+1,tmpMap);
				for(int j=0;j<N;++j) {
					for(int k=0;k<M;++k) {
						tmpMap[j][k]=map[j][k];
					}
				}
				break;
			}
		}
	}
	public static class CCTV{
		int r;
		int c;
		int d;
		public CCTV(int r, int c, int d) {
			this.r=r;
			this.c=c;
			this.d=d;
		}
	}
}
