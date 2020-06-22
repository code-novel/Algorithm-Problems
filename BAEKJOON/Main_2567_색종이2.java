import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int [][]map=new int[101][101];
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st;
		for(int i=0;i<N;++i) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			for(int j=x;j<x+10;++j) {
				for(int k=y;k<y+10;++k) {
					map[j][k]=1;
				}
			}
		}
		int cnt=0;
		int []dx= {-1,1,0,0};
		int []dy= {0,0,-1,1};
		for(int i=0;i<=100;++i) {
			for(int j=0;j<=100;++j) {
				if(map[i][j]==1) {
					int flag=0;
					for(int k=0;k<4;++k) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						if(nx>=0&&ny>=0&&nx<=100&&ny<=100) {
							if(map[nx][ny]==0)flag++;
						}
					}
					cnt+=flag;
				}
			}
		}
		System.out.println(cnt);
	}
}
