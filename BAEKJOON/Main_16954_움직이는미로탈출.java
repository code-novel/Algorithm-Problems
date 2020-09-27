import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16954_움직이는미로탈출{
	public static int[][] map;
	public static int ans=0;
	public static int[] dx= {0,-1,-1,-1,0,1,1, 1, 0};
	public static int[] dy= {0,-1, 0, 1,1,1,0,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		map=new int[10][10];
		for(int i=0;i<10;++i) {
			Arrays.fill(map[i], 1);
		}
		for(int i=1;i<=8;++i) {
			String s=br.readLine();
			for(int j=1;j<=8;++j) {
				char now=s.charAt(j-1);
				if(now=='.') map[i][j]=0;
				else map[i][j]=1;
			}
		}
		bfs();
		System.out.println(ans);
	}
	public static void bfs() {
		Queue<Node> q= new LinkedList<>();
		boolean[][][] isVisited=new boolean[10][10][10];
		q.add(new Node(8,1));
		int time=1;
		while(!q.isEmpty()) {
			int q_size=q.size();
			for(int k=0;k<q_size;++k) {
				Node n=q.poll();
				if(map[n.r][n.c]==1) continue;
				if(n.r==1) {
					ans=1;
					return;
				}
				for(int i=0;i<9;++i) {
					int nr=n.r+dx[i];
					int nc=n.c+dy[i];
					if(!isVisited[nr][nc][time]&&map[nr][nc]==0) {
						isVisited[nr][nc][time]=true;
						q.add(new Node(nr,nc));
					}
				}
			}
			if(time>8&&!q.isEmpty()) {ans=1; return;}
			movingMap(time);
			time++;
		}
	}
	public static void movingMap(int time) {
		for(int i=8;i>time;--i) {
			map[i]=map[i-1].clone();
		}
		Arrays.fill(map[time], 0);
		map[time][0]=1;
		map[time][9]=1;
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