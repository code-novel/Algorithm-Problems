import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_1953_탈주범검거 {
    public static int N, M, R, C, L;
    public static int map[][];
    public static boolean isVisited[][];
    public static boolean canGo[][];
    public static int ans;
    public static int[] dirR = { -1, 1, 0, 0 };
    public static int[] dirC = { 0, 0, -1, 1 };
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken()) + 1;
            C = Integer.parseInt(st.nextToken()) + 1;
            L = Integer.parseInt(st.nextToken());
            map = new int[N + 2][M + 2];
            isVisited = new boolean[N + 2][M + 2];
            canGo = new boolean[N + 2][M + 2];
            for (int i = 1; i <= N; ++i) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ans = 0;
            bfs(R, C);
            System.out.println("#" + t + " " + ans);
        }
    }
    private static void bfs(int r, int c) {
        ans++;
        isVisited[r][c] = true;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { r, c });
        int size=q.size();
        int lv=1;
        while (lv<L&&!q.isEmpty()) {
            int[] rc = q.poll();
            size--;
            gogoSing(map[rc[0]][rc[1]], rc[0], rc[1]);
            for (int i = 0; i < 4; ++i) {
                int nr = rc[0] + dirR[i];
                int nc = rc[1] + dirC[i];
                if (!isVisited[nr][nc] && canGo[nr][nc] && map[nr][nc] != 0) {
                    ans++;
                    isVisited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
            if(size==0) {
                size=q.size();
                lv++;
            }
        }
    }
    private static void gogoSing(int n, int r, int c) {
        int nr, nc;
        LinkedList<int[]> now =new LinkedList<int[]>();
        switch (n) {
        case 1:
            for (int i = 0; i < 4; ++i) {
                nr = r + dirR[i];
                nc = c + dirC[i];
                now.add(new int[] {nr,nc,i});
            }
            break;
        case 2:
            for (int i = 0; i < 2; ++i) {
                nr = r + dirR[i];
                nc = c + dirC[i];
                now.add(new int[] {nr,nc,i});
            }
            break;
        case 3:
            for (int i = 2; i < 4; ++i) {
                nr = r + dirR[i];
                nc = c + dirC[i];
                now.add(new int[] {nr,nc,i});
            }
            break;
        case 4:
            nr = r + dirR[0];
            nc = c + dirC[0];
            now.add(new int[] {nr,nc,0});
            nr = r + dirR[3];
            nc = c + dirC[3];
            now.add(new int[] {nr,nc,3});
            break;
        case 5:
            nr = r + dirR[1];
            nc = c + dirC[1];
            now.add(new int[] {nr,nc,1});
            nr = r + dirR[3];
            nc = c + dirC[3];
            now.add(new int[] {nr,nc,3});
            break;
        case 6:
            nr = r + dirR[1];
            nc = c + dirC[1];
            now.add(new int[] {nr,nc,1});
            nr = r + dirR[2];
            nc = c + dirC[2];
            now.add(new int[] {nr,nc,2});
            break;
        case 7:
            nr = r + dirR[0];
            nc = c + dirC[0];
            now.add(new int[] {nr,nc,0});
            nr = r + dirR[2];
            nc = c + dirC[2];
            now.add(new int[] {nr,nc,2});
            break;
        }
        for(int j=0;j<now.size();++j) {
            switch (map[now.get(j)[0]][now.get(j)[1]]) {
            case 1:
                canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            case 2:
                if(now.get(j)[2]==0||now.get(j)[2]==1)canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            case 3:
                if(now.get(j)[2]==2||now.get(j)[2]==3)canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            case 4:
                if(now.get(j)[2]==1||now.get(j)[2]==2)canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            case 5:
                if(now.get(j)[2]==0||now.get(j)[2]==2)canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            case 6:
                if(now.get(j)[2]==0||now.get(j)[2]==3)canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            case 7:
                if(now.get(j)[2]==1||now.get(j)[2]==3)canGo[now.get(j)[0]][now.get(j)[1]]=true;
                break;
            }
        }
    }
}