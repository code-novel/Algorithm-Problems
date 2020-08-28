import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_16235_나무재테크{
	public static int N, M, K;
	public static int[][]map;
	public static int[][]dead;	//시간 초과로 바로 저장해 두었다가 A합칠 때 같이 합치기!
	public static int[][]A;
	public static int[]dx= {-1,-1,-1,0,0,1,1,1};
	public static int[]dy= {-1,0,1,-1,1,-1,0,1};
	public static List<int[]> list=new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+2][N+2];
		dead=new int[N+2][N+2];
		A=new int[N+2][N+2];
		Arrays.fill(map[0], -1);
		Arrays.fill(map[N+1], -1);
		for(int i=1;i<=N;++i) {
			Arrays.fill(map[i], -1);
			for(int j=1;j<=N;++j) {
				map[i][j]=5;
			}
		}
		for(int i=1;i<=N;++i) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;++j) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;++i) {
			st=new StringTokenizer(br.readLine());
			int tmp[]=new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			list.add(tmp);
		}
		Collections.sort(list,new Comparator<int[]>() {		//오름차순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		for(int i=0;i<K;++i) {
			spring();
			winter();
		}
		System.out.println(list.size());
	}
	public static void spring() {
		List<int[]> tmpList=new LinkedList<>();
		ListIterator<int[]> it =list.listIterator();
		while(it.hasNext()) {
			int[] tmp=it.next();
			if(map[tmp[0]][tmp[1]]<tmp[2]) {	// 나무가 죽을 경우
				dead[tmp[0]][tmp[1]]+=tmp[2]/2;	// dead라는 map에 저장해뒀다가 겨울에 같이 합치기(여름)
				it.remove();
			}else {
				map[tmp[0]][tmp[1]]-=tmp[2];	// map에 저장된 양분에서 나무 나이만큼 빼준다.
				tmp[2]++;
				it.set(tmp);
				if(tmp[2]%5==0) {			// 나무의 나이가 5의 배수면 바로 가을 증식 시켜줌.
					for(int j=0;j<8;++j) {		// 8방향
						int nr=tmp[0]+dx[j];
						int nc=tmp[1]+dy[j];
						if(map[nr][nc]!=-1) {	//땅안의 범위일 경우
							tmpList.add(new int[] {nr,nc,1});	//tmpList에 추가해놓음.
						}
					}
				}
			}
		}
		list.addAll(0,tmpList);		//새로 생긴 나무 합치기.
	}
	public static void winter() {				//여름과 겨울을 위한 메서드
		for(int i=1;i<=N;++i) {
			for(int j=1;j<=N;++j) {
				map[i][j]+=A[i][j]+dead[i][j];	//미리 체크해둔 죽은 나무의 양분과 로봇이 주는 양분을 같이 넣어줌.
				dead[i][j]=0;					//죽은 나무의 양분 0으로 초기화
			}
		}
	}
}