import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667_단지번호붙이기_BFS {
	public static int dx[] = { -1, 1, 0, 0 };
	public static int dy[] = { 0, 0, 1, -1 };
	public static int[][] map;
	public static boolean[][] visited;
	public static int tmp;
	public static List<Integer> danji = new LinkedList<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		visited = new boolean[N + 2][N + 2];
		for (int i = 1; i <= N; ++i) {
			String str = br.readLine();
			for (int j = 1; j <= N; ++j) {
				map[i][j] = (int) str.charAt(j - 1) - 48;
			}
		}
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					tmp=1;
					bfs(i, j);
					danji.add(tmp);
				}
			}
		}
		danji.sort(null);
		System.out.println(danji.size());
		for (int dj : danji)
			System.out.println(dj);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[]{r,c});
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] current=q.poll();
			for (int d = 0; d < 4; ++d) {
				int ni = current[0] + dx[d];
				int nj = current[1] + dy[d];
				if (map[ni][nj] == 1 && visited[ni][nj] == false) {
					visited[ni][nj] = true;
					q.offer(new int[]{ni,nj});
					tmp++;
				}
			}
		}
	}
}