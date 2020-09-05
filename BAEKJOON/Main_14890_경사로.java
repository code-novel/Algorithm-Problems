import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로{
	public static int N, L;
	public static int map[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		map=new int[N+2][N+2];
		for(int i=1;i<N+1;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<N+1;++j) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		for(int i=1;i<N+1;++i) {
			boolean gil=true;
			boolean ksr[]=new boolean[N+1];
			for(int j=1;j<N;++j) {
				if(map[i][j]==map[i][j+1])continue;
				else if(map[i][j]==map[i][j+1]+1) {
					int go=j+1;
					boolean ks=true;
					if(go+L-1>N) {
						gil=false;
						break;
					}else {
						for(int k=go; k<go+L;++k) {
							if(map[i][k]!=map[i][go]||ksr[k]) {
								ks=false;
								break;
							}
						}
						if(ks) {
							for(int k=go; k<go+L;++k) {
								ksr[k]=true;
							}
							j=go+L-2;
						}else {
							gil=false;
						}
					}
				}else if(map[i][j]+1==map[i][j+1]) {
					int go=j;
					boolean ks=true;
					if(go-L<0) {
						gil=false;
						break;
					}else {
						for(int k=go; k>go-L;--k) {
							if(map[i][k]!=map[i][go]||ksr[k]) {
								ks=false;
								break;
							}
						}
						if(!ks) {
							gil=false;
						}else {
							for(int k=go; k>go-L;--k) {
								ksr[k]=true;
							}
						}
					}
				}else {
					gil=false;
					break;
				}
			}
			if(gil)cnt++;
		}
		for(int i=1;i<N+1;++i) {
			boolean gil=true;
			boolean ksr[]=new boolean[N+1];
			for(int j=1;j<N;++j) {
				if(map[j][i]==map[j+1][i])continue;
				else if(map[j][i]==map[j+1][i]+1) {
					int go=j+1;
					boolean ks=true;
					if(go+L-1>N) {
						gil=false;
						break;
					}else {
						for(int k=go; k<go+L;++k) {
							if(map[k][i]!=map[go][i]||ksr[k]) {
								ks=false;
								break;
							}
						}
						if(ks) {
							for(int k=go; k<go+L;++k) {
								ksr[k]=true;
							}
							j=go+L-2;
						}else {
							gil=false;
						}
					}
				}else if(map[j][i]+1==map[j+1][i]) {
					int go=j;
					boolean ks=true;
					if(go-L<0) {
						gil=false;
						break;
					}else {
						for(int k=go; k>go-L;--k) {
							if(map[j][i]!=map[go][i]||ksr[k]) {
								ks=false;
								break;
							}
						}
						if(!ks) {
							gil=false;
						}else {
							for(int k=go; k>go-L;--k) {
								ksr[k]=true;
							}
						}
					}
				}else {
					gil=false;
					break;
				}
			}
			if(gil)cnt++;
		}
		System.out.println(cnt);
	}
}