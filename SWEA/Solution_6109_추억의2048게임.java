import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_6109_추억의2048게임 {
    public static int N;
    public static int[][]map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            String move=st.nextToken();
            map=new int [N][N];
            for(int i=0;i<N;++i) {
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;++j) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            switch(move){
                case "up":
                    up();
                    break;
                case "down":
                    down();
                    break;
                case "left":
                    left();
                    break;
                case "right":
                    right();
                    break;
                 
            }
             
            System.out.println("#"+t);
            for(int i=0;i<N;++i) {
                for(int j=0;j<N;++j) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
    private static void right() {
        int tmpmap[][]=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=N-1;
            for(int j=N-1;j>-1;--j) {
                if(map[i][j]!=0) {
                    tmpmap[i][idx--]=map[i][j];
                }
            }
        }
        map=tmpmap;
        for(int i=N-1;i>0;--i) {
            for(int j=0; j<N;++j) {
                if(map[j][i]!=0&&map[j][i]==map[j][i-1]) {
                    map[j][i]*=2;
                    map[j][i-1]=0;
                }
            }
        }
        tmpmap=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=N-1;
            for(int j=N-1;j>-1;--j) {
                if(map[i][j]!=0) {
                    tmpmap[i][idx--]=map[i][j];
                }
            }
        }
        map=tmpmap;
    }
    private static void left() {
        int tmpmap[][]=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=0;
            for(int j=0;j<N;++j) {
                if(map[i][j]!=0) {
                    tmpmap[i][idx++]=map[i][j];
                }
            }
        }
        map=tmpmap;
        for(int i=0;i<N-1;++i) {
            for(int j=0; j<N;++j) {
                if(map[j][i]!=0&&map[j][i]==map[j][i+1]) {
                    map[j][i]*=2;
                    map[j][i+1]=0;
                }
            }
        }
        tmpmap=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=0;
            for(int j=0;j<N;++j) {
                if(map[i][j]!=0) {
                    tmpmap[i][idx++]=map[i][j];
                }
            }
        }
        map=tmpmap;
         
    }
    private static void down() {
        int tmpmap[][]=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=N-1;
            for(int j=N-1;j>-1;--j) {
                if(map[j][i]!=0) {
                    tmpmap[idx--][i]=map[j][i];
                }
            }
        }
        map=tmpmap;
        for(int i=N-1;i>0;--i) {
            for(int j=0; j<N;++j) {
                if(map[i][j]!=0&&map[i][j]==map[i-1][j]) {
                    map[i][j]*=2;
                    map[i-1][j]=0;
                }
            }
        }
        tmpmap=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=N-1;
            for(int j=N-1;j>-1;--j) {
                if(map[j][i]!=0) {
                    tmpmap[idx--][i]=map[j][i];
                }
            }
        }
        map=tmpmap;
    }
    private static void up() {
        int tmpmap[][]=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=0;
            for(int j=0;j<N;++j) {
                if(map[j][i]!=0) {
                    tmpmap[idx++][i]=map[j][i];
                }
            }
        }
        map=tmpmap;
        for(int i=0;i<N-1;++i) {
            for(int j=0; j<N;++j) {
                if(map[i][j]!=0&&map[i][j]==map[i+1][j]) {
                    map[i][j]*=2;
                    map[i+1][j]=0;
                }
            }
        }
        tmpmap=new int[N][N];
        for(int i=0;i<N;++i) {
            int idx=0;
            for(int j=0;j<N;++j) {
                if(map[j][i]!=0) {
                    tmpmap[idx++][i]=map[j][i];
                }
            }
        }
        map=tmpmap;
    }
 
}