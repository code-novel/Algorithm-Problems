import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_3190_뱀{
	public static int N, K, L;
	public static int[][] bam;
	public static PriorityQueue<Turn> turn;
	public static int[] dx= {0,0,0,-1,1};	//0, 1, 2, 3이 방향 
	public static int[] dy= {0,-1,1,0,0};	//0이 왼쪽 1이 오른쪽 2가 위쪽 3이 아래
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		bam=new int[N+2][N+2];
		StringTokenizer st;
		for(int i=0;i<K;++i) {
			st=new StringTokenizer(br.readLine());
			bam[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=9;
		}
		L=Integer.parseInt(br.readLine());
		turn=new PriorityQueue<Turn>(new Comparator<Turn>() {
			@Override
			public int compare(Turn o1, Turn o2) {
				return o1.time-o2.time;
			}
		});
		for(int i=0;i<L;++i) {
			st=new StringTokenizer(br.readLine());
			turn.add(new Turn(Integer.parseInt(st.nextToken()),st.nextToken().charAt(0)));
		}
		bam[1][1]=2;
		Head head=new Head(1,1,2);
		Head tail=new Head(1,1,2);
		int cnt=0;
		while(true) {
			cnt++;
			int nr=head.r+dx[head.d];
			int nc=head.c+dy[head.d];
			if(nr>0&&nc>0&&nr<N+1&&nc<N+1) {
				if(bam[nr][nc]!=0&&bam[nr][nc]!=9) {
					break;
				}
				if(bam[nr][nc]==9) {
					bam[nr][nc]=head.d;
					head=new Head(nr,nc,head.d);
				}else {
					bam[nr][nc]=head.d;
					head=new Head(nr,nc,head.d);
					int ntr=tail.r+dx[bam[tail.r][tail.c]];
					int ntc=tail.c+dy[bam[tail.r][tail.c]];
					int td=bam[tail.r][tail.c];
					bam[tail.r][tail.c]=0;
					tail=new Head(ntr,ntc,td);
				}
			}else {
				break;
			}
			if(!turn.isEmpty()&&cnt==turn.peek().time) {
				Turn t=turn.poll();
				head.d=changeDir(head.d,t.dir);
				bam[head.r][head.c]=head.d;
			}
		}
		System.out.println(cnt);
	}
	public static int changeDir(int now, char dir) {
		if(now==1) {
			if(dir=='L') return 4;
			else return 3;
		}else if(now==2) {
			if(dir=='L') return 3;
			else return 4;
		}else if(now==3) {
			if(dir=='L') return 1;
			else return 2;
		}else {
			if(dir=='L') return 2;
			else return 1;
		}
	}
	public static class Head{
		int r;
		int c;
		int d;
		public Head(int r, int c, int d) {
			this.r=r;
			this.c=c;
			this.d=d;
		}
	}

	public static class Turn{
		int time;
		char dir;
		public Turn(int t, char d) {
			this.time = t;
			this.dir = d;
		}
	}
}