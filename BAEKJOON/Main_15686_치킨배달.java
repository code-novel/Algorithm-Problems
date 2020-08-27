import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달{
	public static int N, M;
	public static int [][] map;
	public static List<int[]> dak=new LinkedList<>();
	public static List<int[]> zip=new LinkedList<>();
	public static boolean[] isCheck;
	public static int min=Integer.MAX_VALUE;
	public static int[] dx= {0,0,-1,1};
	public static int[] dy= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		for(int i=0;i<N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1){
					zip.add(new int[] {i,j});
				}else if(map[i][j]==2) {
					dak.add(new int[] {i,j});
				}
			}
		}
		isCheck=new boolean[dak.size()];
		combi(0,0);
		System.out.println(min);
	}
	public static void combi(int idx, int sel) {
		if(sel==M) {
			int len=0;
			for(int i=0;i<zip.size();++i) {
				int tmp_len=Integer.MAX_VALUE;
				int []tmp_zip=zip.get(i);
				for(int j=0;j<dak.size();++j) {
					if(isCheck[j]) {
						tmp_len=Math.min(tmp_len, Math.abs(tmp_zip[0]-dak.get(j)[0])+Math.abs(tmp_zip[1]-dak.get(j)[1]));
					}
					if(tmp_len==1)break;
				}
				len+=tmp_len;
			}
			min=Math.min(min, len);
			return;
		}else if(dak.size()-idx<M-sel){
			return;
		}
		else {
			isCheck[idx]=true;
			combi(idx+1,sel+1);
			isCheck[idx]=false;
			combi(idx+1,sel);
		}
	}
}