import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3{
	public static int N, M, len;
	public static int[]dx= {-1,1,0,0};
	public static int[]dy= {0,0,-1,1};
	public static int[][]map;
	public static boolean[] isCheck;
	public static int min=Integer.MAX_VALUE;
	public static LinkedList<Node> list=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		boolean end=true;
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					list.add(new Node(i,j));
				}else if(map[i][j]==0) {
					end=false;
				}
			}
		}
		if(end) {
			System.out.println(0);
			return;
		}
		len=list.size();
		isCheck=new boolean[len];
		virus(0, 0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	public static void virus(int idx,int sel) {
		if(sel==M) {
			Queue<Node> q=new LinkedList<>();
			boolean[][] isVisited=new boolean[N][N];
			int[][]tmpMap=new int[N][N];
			for(int i=0;i<len;++i) {
				if(isCheck[i]) {
					q.add(list.get(i));
					isVisited[list.get(i).r][list.get(i).c]=true;
				}
			}
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					tmpMap[i][j]=map[i][j];
				}
			}
			int time=1;
			while(!q.isEmpty()) {
				int q_size=q.size();
				for(int i=0;i<q_size;++i) {
					Node n=q.poll();
					for(int j=0;j<4;++j) {
						int nr=n.r+dx[j];
						int nc=n.c+dy[j];
						if(nr>-1&&nc>-1&&nr<N&&nc<N&&!isVisited[nr][nc]&&tmpMap[nr][nc]!=1) {
							tmpMap[nr][nc]=2;
							isVisited[nr][nc]=true;
							q.add(new Node(nr,nc));
						}
					}
				}
				boolean end=true;
				for(int i=0;i<N;++i) {
					for(int j=0;j<N;++j) {
						if(tmpMap[i][j]==0) {
							end=false;
						}
					}
				}
				if(end) {
					min=Math.min(min, time);
					return;
				}
				time++;
			}
			return;
		}else if(M-sel>len-idx) {
			return;
		}else {
			virus(idx+1,sel);
			isCheck[idx]=true;
			virus(idx+1, sel+1);
			isCheck[idx]=false;
		}
	}
	public static class Node{
		int r;
		int c;
		public Node(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
}