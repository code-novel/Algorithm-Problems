import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_7576_토마토 {
	public static int M, N;
	public static int[][] map;
	public static int[] dx= {0,0,-1,1};
	public static int[] dy= {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M= Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		Queue<int[]> q=new LinkedList<>();
		int tomato=0;
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;++j) {
				int tmp=Integer.parseInt(st.nextToken());
				if(tmp==1) {
					q.add(new int[] {i,j});
				}else if(tmp==0){
					tomato++;
				}
				map[i][j]=tmp;
			}
		}
		if(tomato==0)System.out.println(0);
		else {
			int q_size=q.size();
			int day=1;
			while(!q.isEmpty()) {
				for(int i=0;i<q_size;++i) {
					int []now=q.poll();
					for(int j=0;j<4;++j) {
						int nr=now[0]+dx[j];
						int nc=now[1]+dy[j];
						if(nr>-1&&nc>-1&&nr<N&&nc<M&&map[nr][nc]==0) {
							map[nr][nc]=1;
							tomato--;
							q.add(new int[] {nr,nc});
						}
					}
				}
				if(tomato==0) {System.out.println(day);break;}
				else {
					day++;
					q_size=q.size();
				}
			}
			if(tomato>0)
				System.out.println(-1);
		}
	}
}
