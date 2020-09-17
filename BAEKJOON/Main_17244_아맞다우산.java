import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17244_아맞다우산{
	public static int R, C;
	public static char[][] map;
	public static Node start, end, go;
	public static LinkedList<Node> list=new LinkedList<>();
	public static int[] getX;
	public static int[] dx= {-1,1,0,0};
	public static int[] dy= {0,0,-1,1};
	public static int num, ans, min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		C=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		num=0;
		for(int i=0;i<R;++i) {
			String s= br.readLine();
			for(int j=0;j<C;++j) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='S') {
					start=new Node(i,j);
					map[i][j]='.';
				}else if(map[i][j]=='E') {
					end=new Node(i,j);
					map[i][j]='#';
				}else if(map[i][j]=='X') {
					list.add(new Node(i,j));
					num++;
				}
			}
		}
		if(num!=0) {
			getX=new int[num];
			for(int i=0;i<num;++i) {
				getX[i]=i;
			}
			do {
				go=new Node(start.r, start.c);
				ans=0;
				for(int i=0;i<num;++i) {
					getKeys(i);
				}
				bfs();
				min=Math.min(ans, min);
			}while(nextPermutation());
		}else {
			go=new Node(start.r, start.c);
			bfs();
			min=Math.min(ans, min);
		}
		System.out.println(min);
	}
	public static void bfs() {
		Queue<Node> q=new LinkedList<>();
		boolean isVisited[][]=new boolean[R][C];
		q.add(go);
		isVisited[go.r][go.c]=true;
		int time=1;
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int k=0;k<q_size;++k) {
				Node now=q.poll();
				for(int i=0;i<4;++i) {
					int nr=now.r+dx[i];
					int nc=now.c+dy[i];
					if(!isVisited[nr][nc]&&nr==end.r&&nc==end.c) {
						ans+=time;
						return;
					}
					else if(!isVisited[nr][nc]&&map[nr][nc]!='#') {
						isVisited[nr][nc]=true;
						q.add(new Node(nr,nc));
					}
				}
			}
			time++;
		}
	}
	public static void getKeys(int key) {
		int fr=list.get(getX[key]).r;
		int fc=list.get(getX[key]).c;
		Queue<Node> q=new LinkedList<>();
		boolean isVisited[][]=new boolean[R][C];
		q.add(go);
		isVisited[go.r][go.c]=true;
		int time=1;
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int k=0;k<q_size;++k) {
				Node now=q.poll();
				for(int i=0;i<4;++i) {
					int nr=now.r+dx[i];
					int nc=now.c+dy[i];
					if(!isVisited[nr][nc]&&nr==fr&&nc==fc) {
						go=new Node(nr,nc);
						ans+=time;
						return;
					}
					else if(!isVisited[nr][nc]&&map[nr][nc]!='#') {
						isVisited[nr][nc]=true;
						q.add(new Node(nr,nc));
					}
				}
			}
			time++;
		}
	}
	public static boolean nextPermutation() {
		int i=num-1;
		while(i>0&&getX[i-1]>=getX[i]) i--;
		if(i==0) return false;
		int j=num-1;
		while(getX[i-1]>=getX[j]) j--;
		swap(i-1,j);
		j=num-1;
		while(i<j) {
			swap(i++,j--);
		}
		return true;
	}
	public static void swap(int k, int l) {
		int tmp=getX[k];
		getX[k]=getX[l];
		getX[l]=tmp;
	}
	public static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r=r;
			this.c=c;
		}
	}
}