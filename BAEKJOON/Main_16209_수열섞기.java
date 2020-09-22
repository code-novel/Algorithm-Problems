import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_16209_수열섞기{
	public static int N;
	public static int zeroNum=0;
	public static ArrayList<Integer> plus=new ArrayList<>();
	public static ArrayList<Integer> minus=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;++i) {
			int n=Integer.parseInt(st.nextToken());
			if(n>0) {
				plus.add(n);
			}else if(n==0) {
				zeroNum++;
			}else {
				minus.add(n);
			}
		}
		Collections.sort(plus, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		Collections.sort(minus, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		if(minus.size()>0) {
			for(int i=1;i<minus.size();i+=2) {
				sb.append(minus.get(i)).append(" ");
			}
			int start=(minus.size()-1)/2*2;
			for(int i=start;i>-1;i-=2) {
				sb.append(minus.get(i)).append(" ");
			}
		}
		for(int i=0;i<zeroNum;++i) {
			sb.append(0).append(" ");
		}
		for(int i=0;i<plus.size();i+=2) {
			sb.append(plus.get(i)).append(" ");
		}
		int start=plus.size()/2*2-1;
		for(int i=start;i>-1;i-=2) {
			sb.append(plus.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
}