import java.util.Scanner;

public class Main_2933_미네랄 {
	public static int[] dirr = { 1, -1, 0, 0 };
	public static int[] dirc = { 0, 0, -1, 1 };
	public static char map[][];
	public static int R, C;
	public static boolean isVisited[][];
	public static int cnt;
	public static int tmp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];

		for (int i = 0; i < R; ++i) {
			map[i] = sc.next().toCharArray();
		}
		int N = sc.nextInt();
		for (int i = 0; i < N; ++i) {
			cnt = 0;
			isVisited = new boolean[R][C];
			int dol = sc.nextInt();
			if (i % 2 == 0) {
				for (int j = 0; j < C; ++j) {
					if (map[R - dol][j] == 'x') {
						map[R - dol][j] = '.';
						break;
					}
				}
			} else {
				for (int j = C - 1; j > -1; --j) {
					if (map[R - dol][j] == 'x') {
						map[R - dol][j] = '.';
						break;
					}
				}
			}
			for (int j = 0; j < R; ++j) {
				for (int k = 0; k < C; ++k) {
					if (!isVisited[j][k] && map[j][k] == 'x') {
						cnt++;
						dfs(j, k);
					}
				}
			}
			boolean[] chk = new boolean[cnt + 1];
			for (int k = 0; k < C; ++k) {
				if (map[R-1][k] != '.') {
					chk[map[R-1][k]-'0'] = true;
				}
			}
			for (int j = 1; j <= cnt; ++j) {
				if (chk[j])
					continue;
				else {
					while(!chk[j]&&koong((char) (j+48))) {
						move((char) (j+48));
						for (int k = 0; k < C; ++k) {
							if (map[R-1][k] == j+'0') {
								chk[j] = true;
							}
						}
					}
				}
			}

			for (int j = 0; j < R; ++j) {
				for (int k = 0; k < C; ++k) {
					if (map[j][k] != '.') {
						map[j][k] = 'x';
					}
				}
			}
		}
		for (int j = 0; j < R; ++j) {
			for (int k = 0; k < C; ++k) {
				System.out.print(map[j][k]);
			}
			System.out.println();
		}
	}

	public static void dfs(int r, int c) {
		isVisited[r][c] = true;
		map[r][c] = (char) (cnt + 48);
		for (int i = 0; i < 4; ++i) {
			int nr = r + dirr[i];
			int nc = c + dirc[i];
			if (nr > -1 && nc > -1 && nr < R && nc < C && !isVisited[nr][nc] && map[nr][nc] == 'x') {
				dfs(nr, nc);
			}
		}
	}

	public static void move(char down) {
		for (int i = R - 1; i > -1; --i) {
			for (int j = C - 1; j > -1; --j) {
				if (map[i][j] == down) {
					map[i + 1][j] = map[i][j];
					map[i][j] = '.';
				}
			}
		}
	}
	public static boolean koong(char down) {
		boolean chk=true;
		for (int i = R - 2; i > -1; --i) {
			for (int j = C - 1; j > -1; --j) {
				if (map[i][j] == down&&map[i + 1][j]!='.'&&map[i+1][j] != down) {
					chk=false;
					break;
				}
			}
		}
		return chk; 
	}
}
