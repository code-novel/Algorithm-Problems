import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	public static int[][] map;
	public static int[][] temp;
	public static boolean isVisited[][];
	public static int dirx[] = { -1, 1, 0, 0 };
	public static int diry[] = { 0, 0, -1, 1 };
	public static int N, M;
	public static int count = 0, max = 0;;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		temp = new int[N + 2][M + 2];
		for (int i = 0; i <= N + 1; ++i) {
			for (int j = 0; j <= M + 1; ++j) {
				map[i][j] = -1;
				temp[i][j] = -1;
			}
		}
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= M; ++j) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(i, j, 1);
					map[i][j] = 0;
				}
			}
		}
		System.out.println(max);
	}

	public static void dfs(int r, int c, int cnt) {
		if (cnt == 3) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					temp[i][j] = map[i][j];
				}
			}
			isVisited = new boolean[N + 2][M + 2];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (!isVisited[i][j]&&temp[i][j] == 2) {
						isVisited[i][j]=true;
						virus(i,j);
					}
				}
			}
			for (int k = 1; k <= N; ++k) {
				for (int l = 1; l <= M; ++l) {
					if (temp[k][l] == 0)
						count++;
				}
			}
			if(max<count)max=count;
			count=0;
		}
		else {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= M; ++j) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						dfs(i, j, cnt+1);
					}
				}
			}
		}
		map[r][c] = 0;
	}
	public static void virus(int r, int c) {
		for (int k = 0; k < 4; ++k) {
			int nr = r + dirx[k];
			int nc = c + diry[k];
			if (!isVisited[nr][nc] && temp[nr][nc] == 0) {
				isVisited[nr][nc] = true;
				temp[nr][nc] = 2;
				virus(nr,nc);
			}
		}
	}
}