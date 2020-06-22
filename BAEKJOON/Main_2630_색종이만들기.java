import java.util.Scanner;

public class Main_2630_색종이만들기{
	public static int map[][];
	public static int b=0, w=0;
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		map=new int[N][N];
		for(int i=0;i<N;++i) {
			for(int j=0;j<N;++j) {
				map[i][j]=sc.nextInt();
			}
		}
		cut(N,0,0);
		System.out.println(w+"\n"+b);

	}
	private static void cut(int n, int x, int y) {
		// TODO Auto-generated method stub
		int color=map[x][y];
		for(int i=x;i<x+n;++i) {
			for(int j=y;j<y+n;++j) {
				if(map[i][j]!=color) {
					cut(n/2,x,y);
					cut(n/2,x+n/2,y);
					cut(n/2,x,y+n/2);
					cut(n/2,x+n/2,y+n/2);
					return;
				}
			}
			
		}
		if(color==1) {
			b++;
		}else {
			w++;
		}
		
	}
}
