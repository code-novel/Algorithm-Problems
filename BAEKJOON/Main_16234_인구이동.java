import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동{
	public static int N, L,R;
	public static int cnt=0;
	public static int dx[]= {-1,1,0,0};
	public static int dy[]= {0,0,-1,1};
	public static int [][]map;
	public static int union[][];
	public static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			union=new int[N][N];
			list=new LinkedList<>();
			int num=0;
			for(int i=0;i<N;++i) {
				for(int j=0;j<N;++j) {
					if(union[i][j]==0) {
						num++;
						bfs(i,j,num);
					}
				}
			}
			if(num==N*N)break;
			else {
				cnt++;
				for(int i=0;i<N;++i) {
					for(int j=0;j<N;++j) {
						map[i][j]=list.get(union[i][j]-1);
					}
				}
			}
		}
		System.out.println(cnt);
	}
	public static void bfs(int r, int c, int n) {
		Queue<int[]> q=new LinkedList<>();
		int total=0;
		int cnt=0;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int []tmp=q.poll();
			if(union[tmp[0]][tmp[1]]!=0)continue;
			union[tmp[0]][tmp[1]]=n;
			total+=map[tmp[0]][tmp[1]];
			cnt++;
			for(int i=0;i<4;++i) {
				int nr=tmp[0]+dx[i];
				int nc=tmp[1]+dy[i];
				if(nr>-1&&nc>-1&&nr<N&&nc<N&&Math.abs(map[tmp[0]][tmp[1]]-map[nr][nc])>=L&&Math.abs(map[tmp[0]][tmp[1]]-map[nr][nc])<=R&&union[nr][nc]==0) {
					q.add(new int[] {nr,nc});
				}
			}
		}
		list.add(total/cnt);
	}
}