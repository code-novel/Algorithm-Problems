import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이{

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
		for(int i=0;i<=100;++i) {
			for(int j=0;j<=100;++j) {
				if(map[i][j]==1)cnt++;
			}
		}
		System.out.println(cnt);
	}
}