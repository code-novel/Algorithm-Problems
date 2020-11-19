import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution_2806_N_Queen {
    static int[] board;
    static int N, res;
    static void nQueen(int q ) {
        if( q == N ) {
            res++;
            return;
        }
        for( int i=0; i<N; i++ ) {
            boolean chk = true;
            for( int j=0; j<q; j++ ) {
                if( board[j] == i || Math.abs(q-j) == Math.abs(i-board[j]) ) {
                    chk = false;
                    break;
                }
            }
            if( chk ) {
                board[q] = i;
                nQueen(q+1);
            }
        }
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N];
            res = 0;
            nQueen(0);
            System.out.println("#"+t+" "+res);
        }
    }
}