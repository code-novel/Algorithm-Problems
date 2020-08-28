import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어{
	public static int N;
	public static int [][] map;
	public static int r,c, size, tmpSize, time;
	public static int []dx= {-1,0,0,1};
	public static int []dy= {0,-1,1,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int [N][N];
		for(int i=0;i<N;++i) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					r=i;
					c=j;
				}
			}
		}
		size=2;
		tmpSize=0;
		time=0;
		int tmpTime=Integer.MAX_VALUE;
		while(tmpTime!=0) {
			tmpTime=bfs();
			time+=tmpTime;
			if(size==tmpSize) {
				size++;
				tmpSize=0;
			}
		}
		System.out.println(time);
	}
	public static int bfs() {
		Queue <int[]>q=new LinkedList<>();
		q.add(new int[] {r,c});
		int time=1;
		boolean isVisited[][]=new boolean[N][N];
		boolean isCheck=false;
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0])
					return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int p=0;p<q_size;++p) {
				int []tmp=q.poll();
				for(int i=0;i<4;++i) {
					int nr=tmp[0]+dx[i];
					int nc=tmp[1]+dy[i];
					if(nr>-1&&nc>-1&&nr<N&&nc<N&&!isVisited[nr][nc]) {
						if(map[nr][nc]==0||map[nr][nc]==size) {
							isVisited[nr][nc]=true;
							q.add(new int[] {nr,nc});
						}
						else if(map[nr][nc]<size) {
							isCheck=true;
							pq.add(new int[] {nr,nc});
						}
					}
				}
			}
			if(isCheck) {
				int[] tmp=pq.poll();
				map[tmp[0]][tmp[1]]=0;
				tmpSize++;
				r=tmp[0];
				c=tmp[1];
				return time;
			}
			time++;
		}
		return 0;
	}
}