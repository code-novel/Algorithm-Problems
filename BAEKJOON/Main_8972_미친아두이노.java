import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_8972_미친아두이노{
	public static int R, C;
	public static int[][] map,checkR;
	public static Queue<Node> robots=new LinkedList<>();
	public static Node adu;
	public static int[] dr= {0,1,1,1,0,0,0,-1,-1,-1};
	public static int[] dc= {0,-1,0,1,-1,0,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new int[R+2][C+2];
		for(int i=0;i<R+2;++i) {
			Arrays.fill(map[i], 1);
		}
		for(int i=1;i<=R;++i) {
			String s=br.readLine();
			for(int j=1;j<=C;++j) {
				char tmp=s.charAt(j-1);
				map[i][j]=0;
				if(tmp=='R') {
					robots.add(new Node(i,j));
					map[i][j]=2;
				}else if(tmp=='I') {
					adu=new Node(i, j);
				}
			}
		}
		String s=br.readLine();
		for(int k=1;k<=s.length();++k) {
			int n=s.charAt(k-1)-'0';
			int nr=adu.r+dr[n];
			int nc=adu.c+dc[n];
			if(map[nr][nc]==2) {
				System.out.println("kraj "+k);
				return;
			}
			adu=new Node(nr,nc);
			checkR=new int[R+2][C+2];
			Queue<Node> tmpQ=new LinkedList<>();
			while(!robots.isEmpty()) {
				Node now=robots.poll();
				map[now.r][now.c]=0;
				int rr=now.r;
				int rc=now.c;
				if(rr<adu.r)rr++;
				else if(rr>adu.r)rr--;
				if(rc<adu.c)rc++;
				else if(rc>adu.c)rc--;
				if(rr==adu.r&&rc==adu.c) {
					System.out.println("kraj "+k);
					return;
				}
				if(checkR[rr][rc]==0) tmpQ.add(new Node(rr,rc));
				checkR[rr][rc]++;
			}
			while(!tmpQ.isEmpty()) {
				Node now=tmpQ.poll();
				if(checkR[now.r][now.c]==1) {
					map[now.r][now.c]=2;
					robots.add(new Node(now.r,now.c));
				}
			}
		}
		for(int i=0;i<robots.size();++i) {
			Node now=robots.poll();
			map[now.r][now.c]=2;
		}
		map[adu.r][adu.c]=1;
		for(int i=1;i<=R;++i) {
			for(int j=1;j<=C;++j) {
				if(map[i][j]==0) {
					System.out.print('.');
				}else if(map[i][j]==1) {
					System.out.print('I');
				}else {
					System.out.print('R');
				}
			}
			System.out.println();
		}
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