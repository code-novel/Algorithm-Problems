import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠{
	public static int N, M;
	public static char[][] map;
	public static boolean[] isOpen;
	public static Point start;
	public static int cnt;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			cnt = 0;
			isOpen = new boolean[26];
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N + 2][M + 2];
			for (int i = 0; i < N + 2; ++i) {
				Arrays.fill(map[i], '.');
			}
			for (int i = 1; i <= N; ++i) {
				String s = br.readLine();
				for (int j = 1; j <= M; ++j) {
					map[i][j] = s.charAt(j - 1);
				}
			}
			String s = br.readLine();
			if (!s.equals("0")) {
				for (int i = 0; i < s.length(); ++i) {
					isOpen[s.charAt(i) - 'a'] = true;
				}
			}
			bfs();
			System.out.println(cnt);
		}
	}

	public static void bfs() {
		start = new Point(0, 0);
		Queue<Point> q = new LinkedList<>();
		boolean[][] isVisited = new boolean[N + 2][M + 2];
		q.add(start);
		isVisited[start.r][start.c] = true;
		boolean repeat=false;
		while (!q.isEmpty()) {
			Point now = q.poll();
		out: for (int i = 0; i < 4; ++i) {
				int nr = now.r + dx[i];
				int nc = now.c + dy[i];
				if (nr > -1 && nc > -1 && nr < N + 2 && nc < M + 2 && !isVisited[nr][nc]) {
					if (map[nr][nc] - 'a' > -1 && map[nr][nc] - 'a' < 26) {
						if (isOpen[map[nr][nc] - 'a']) {
							map[nr][nc] = '.';
						} else {
							isOpen[map[nr][nc] - 'a'] = true;
							start = new Point(nr, nc);
							repeat=true;
							break out;
						}
					} else if (map[nr][nc] - 'A' > -1 && map[nr][nc] - 'A' < 26) {
						if (isOpen[map[nr][nc] - 'A']) {
							map[nr][nc] = '.';
						}
					}else if(map[nr][nc]=='$') {
						cnt++;
						map[nr][nc]='.';
					}
					if (map[nr][nc] == '.') {
						isVisited[nr][nc] = true;
						q.add(new Point(nr, nc));
					}
				}
			}
			if(repeat) {
				q.clear();
				q.add(start);
				isVisited = new boolean[N + 2][M + 2];
				isVisited[start.r][start.c] = true;
				repeat=false;
			}
		}
	}

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}