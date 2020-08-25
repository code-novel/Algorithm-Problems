import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2{
	public static int N, M;
	public static int sum = 0;
	public static int[][] map, dari;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static boolean[][] isVisited;
	public static int[] parents;
	public static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		isVisited = new boolean[N + 2][M + 2];
		for (int i = 0; i <= N + 1; ++i) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; ++i) { // 섬 이름 번호 붙이기
			for (int j = 1; j <= M; ++j) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					sum++;
					dfs(i, j, sum);
				}
			}
		}
		// 각 섬을 잇는 가장 짧은 다리들을 찾아보자!
		dari = new int[sum + 1][sum + 1];
		for (int i = 1; i <= sum; ++i) {
			Arrays.fill(dari[i], Integer.MAX_VALUE);
		}
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= M; ++j) {
				if (map[i][j] > 0) {
					for (int k = 0; k < 4; ++k) {
						int len = 0;
						int nr = i + dx[k];
						int nc = j + dy[k];
						while (map[nr][nc] == 0) {
							len++;
							nr += dx[k];
							nc += dy[k];
						}
						if (map[nr][nc] != -1 && map[nr][nc] != map[i][j] && len > 1) {
							len = Math.min(dari[map[i][j]][map[nr][nc]], len);
							dari[map[i][j]][map[nr][nc]] = len;
							dari[map[nr][nc]][map[i][j]] = len;
						}
					}
				}
			}
		}
		List<int[]> list = new LinkedList<>();

		for (int i = 1; i <= sum; ++i) {
			for (int j = i + 1; j <= sum; ++j) {
				if (dari[i][j] != Integer.MAX_VALUE) {
					list.add(new int[] { i, j, dari[i][j] });
				}
			}
		}
		Collections.sort(list, new Comparator<int[]>() { // 다리 길이 짧은 순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		parents = new int[sum + 1];
		Arrays.fill(parents, -1);
		for (int i = 0; i < list.size(); ++i) {
			int[] tmp = list.get(i);
			if (find(tmp[0]) != find(tmp[1])) {
				ans += tmp[2];
				union(tmp[0], tmp[1]);
			}
		}
		int cnt=0;
		for(int i=1;i<=sum;++i) {
			if(parents[i]==-1)cnt++;
		}
		if(cnt>1)System.out.println(-1);
		else System.out.println(ans);
	}

	public static void dfs(int r, int c, int n) {
		map[r][c] = n;
		isVisited[r][c] = true;
		for (int i = 0; i < 4; ++i) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if (map[nr][nc] == 1 && !isVisited[nr][nc]) {
				dfs(nr, nc, n);
			}
		}
	}

	public static int find(int a) {
		if (parents[a] < 0)
			return a;
		else
			return parents[a] = find(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		else {
			parents[aRoot] = bRoot;
			return true;
		}
	}
}