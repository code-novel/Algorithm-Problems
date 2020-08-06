import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_12100_2048(Easy) {
	static int MAX;
	static int[][] MAP;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine());
		MAP=new int[N][N];
		for(int i=0;i<N;++i) {
			String tmp=br.readLine();
			for(int j=0;j<N;++j) {
				int t=1;
				for(int k=tmp.split(" ")[j].length()-1; k>-1;--k) {
					MAP[i][j]+=(tmp.split(" ")[j].charAt(k)-'0')*t;
					t*=10;
				}
			}
		}
		dfs(0);
		System.out.println(MAX);
	}
	public static void dfs(int d) {
		int[][] tempMap = new int[N+1][N+1];
		copyMap(tempMap, MAP);
		
		if( d == 5) {
			findMaxNumber();
			return;
		}
		for(int i =0 ; i < 4; i++) {
			mergeMap(i); 
			dfs(d+1);
			copyMap(MAP, tempMap);
		}
	}
	
	public static void mergeMap(int d) {
		Queue q= new LinkedList<Integer>();
		int[][] newMap = new int[N+1][N+1];
		
		//UP
		if( d == 0 ) {
			for(int x = 0 ; x < N ;	x++) {
				for(int y = 0; y < N; y++) {
					if(MAP[y][x] != 0 ) {
						q.add(MAP[y][x]);
					}
				}	
				int idx = 0;
				while(!q.isEmpty()) {
					int value = (int) q.peek();
					if (newMap[idx][x] == 0) {
						newMap[idx][x] = (int) q.poll();

					}else if(newMap[idx][x] == value ) {
						newMap[idx][x] += (int) q.poll();
						idx+=1;
						
					}else {
						idx +=1;
						newMap[idx][x] = (int) q.poll();
					}			
				}
			}
		}
		//DOWN
		if( d == 1 ) {

			for(int x = 0 ; x < N ;	x++) {
				for(int y = N-1; y >= 0; y--) {
					if(MAP[y][x] != 0 ) {
						q.add(MAP[y][x]);
					}
				}	
				int idx = N -1;
				while(!q.isEmpty()) {
					int value = (int) q.peek();
					if (newMap[idx][x] == 0) {
						newMap[idx][x] = (int) q.poll();
					}else if(newMap[idx][x] == value ) {
						newMap[idx][x] += (int) q.poll();
						idx-=1;
					}else {
						idx -=1;
						newMap[idx][x] = (int) q.poll();
					}			
				}
			}
		}
		//LEFT
		if( d == 2 ) {
			
			for(int y = 0 ; y < N ;	y++) {
				for(int x = 0; x < N; x++) {
					if(MAP[y][x] != 0 ) {
						q.add(MAP[y][x]);
					}
				}	
				int idx = 0;
				while(!q.isEmpty()) {
					int value = (int) q.peek();
					if (newMap[y][idx] == 0) {
						newMap[y][idx] = (int) q.poll();
					}else if(newMap[y][idx] == value ) {
						newMap[y][idx] += (int) q.poll();
						idx+=1;
					}else {
						idx +=1;
						newMap[y][idx] = (int) q.poll();
					}		
				}
				
			}
		}
		//RIGHT
		if( d == 3 ) {
		
			for(int y = 0 ; y < N ;	y++) {
				for(int x = N -1; x >= 0; x--) {
					if(MAP[y][x] != 0 ) {
						q.add(MAP[y][x]);
					}
				}	
				int idx = N-1;
				while(!q.isEmpty()) {
					int value = (int) q.peek();
					if (newMap[y][idx] == 0) {
						newMap[y][idx] = (int) q.poll();

					}else if(newMap[y][idx] == value ) {
						newMap[y][idx] += (int) q.poll();
						idx-=1;	
					}else {
						idx -=1;
						newMap[y][idx] = (int) q.poll();
					}			
				}
			}
		}
		copyMap(MAP,newMap);
	}
	public static void findMaxNumber() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(  MAX < MAP[i][j]) {
					MAX = MAP[i][j];
				}
			}
		}
	}
	public static void copyMap(int[][] map, int[][] map2) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = map2[i][j];
			}
		}
	}
}
