import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟{
	public static int M,N;
	public static int map[][];
	public static int min;
	public static int value[][];
	public static int dx[]= {0,0,-1,1};
	public static int dy[]= {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[M][N];
		value=new int[M][N];
		for(int i=0;i<M;++i) {
			Arrays.fill(value[i], 9999);
		}
		value[0][0]=0;
		for(int i=0;i<M;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		bfs();
		System.out.println(value[M-1][N-1]);
	}
	public static void bfs() {
		Queue q=new LinkedList<int[]>();
		q.add(new int[]{0,0});
		while(!q.isEmpty()) {
			int[] now =(int[]) q.poll();
			for(int i=0; i<4;++i) {
				int nx=now[0]+dx[i];
				int ny=now[1]+dy[i];
				if(nx>-1&&ny>-1&&nx<M&&ny<N&&value[now[0]][now[1]]+map[nx][ny]<value[nx][ny]) {
					value[nx][ny]=value[now[0]][now[1]]+map[nx][ny];
					q.add(new int[]{nx,ny});
				}
			}
		}
	}

}
