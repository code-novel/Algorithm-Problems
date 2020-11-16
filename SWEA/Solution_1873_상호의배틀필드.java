import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_1873_상호의배틀필드 {
    public static char [][]map;
    public static int posW=0;
    public static int posH=0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int H=Integer.parseInt(st.nextToken());
            int W=Integer.parseInt(st.nextToken());
            map=new char[H+2][W+2];
            for(int i=0;i<=H+1;++i) {
                for(int j=0; j<=W+1;++j) {
                    map[i][j]='#';
                }
            }
            for(int i=1;i<=H;++i) {
                String s= br.readLine();
                for(int j=1; j<=W;++j) {
                    map[i][j]=s.charAt(j-1);
                    if(map[i][j]=='<'||map[i][j]=='>'||map[i][j]=='^'||map[i][j]=='v') {
                        posW=i;posH=j;
                    }
                }
            }
            int N=Integer.parseInt(br.readLine());
            String s=br.readLine();
            for(int i=0;i<N;++i) {
                switch(s.charAt(i)) {
                case 'U': moveUp();
                break;
                case 'D': moveDown();
                break;
                case 'L' : moveLeft();
                break;
                case 'R' : moveRight();
                break;
                case 'S' : shoot();
                break;
                }
            }
            System.out.print("#"+t+" ");
            for(int i=1;i<=H;++i) {
                for(int j=1; j<=W;++j) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void moveUp() {
        map[posW][posH]='.';
        if(map[posW-1][posH]=='.') {map[--posW][posH]='^';}
        else{map[posW][posH]='^';}
    }
    public static void moveDown() {
        map[posW][posH]='.';
        if(map[posW+1][posH]=='.') {map[++posW][posH]='v';}
        else{map[posW][posH]='v';}
    }
    public static void moveLeft() {
        map[posW][posH]='.';
        if(map[posW][posH-1]=='.') {map[posW][--posH]='<';}
        else{map[posW][posH]='<';}
    }
    public static void moveRight() {
        map[posW][posH]='.';
        if(map[posW][posH+1]=='.') {map[posW][++posH]='>';}
        else{map[posW][posH]='>';}
    }
    public static void shoot() {
        int nr=posW;
        int nc=posH;
        if(map[posW][posH]=='<') {
            while(map[nr][nc]!='*'&&map[nr][nc]!='#') {
                nc--;
            }
            if(map[nr][nc]=='*') map[nr][nc]='.';
        }else if(map[posW][posH]=='>') {
            while(map[nr][nc]!='*'&&map[nr][nc]!='#') {
                nc++;
            }
            if(map[nr][nc]=='*') map[nr][nc]='.';
        }else if(map[posW][posH]=='^') {
            while(map[nr][nc]!='*'&&map[nr][nc]!='#') {
                nr--;
            }
            if(map[nr][nc]=='*') map[nr][nc]='.';
        }else if(map[posW][posH]=='v') {
            while(map[nr][nc]!='*'&&map[nr][nc]!='#') {
                nr++;
            }
            if(map[nr][nc]=='*') map[nr][nc]='.';
        }
    }
}