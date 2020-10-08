import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main_1062_가르침{
	public static int N, K, a;
	public static int[] word;
	public static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		setA();
		word=new int[N];
		Arrays.fill(word, a);
		for(int i=0;i<N;++i) {
			String s=br.readLine().replaceAll("[a,c,i,n,t]", "");
			for(int j=0;j<s.length();++j) {
				word[i]|=1<<(s.charAt(j)-'a');
			}
		}
		if(K<5) System.out.println(0);
		else if(K>25) System.out.println(N);
		else {
			K-=5;
			check(1,0);
			System.out.println(ans);
		}
	}
	public static void check(int idx, int cnt) {
		if(ans==N) return;
		if(cnt==K) {
			int val=0;
			for(int i=0;i<N;++i) {
				if((a|word[i])==a)val++;
			}
			ans=Math.max(ans, val);
			return;
		}
		for(int i=idx;i<26;++i) {
			if((a&(1<<i))==0) {
				a|=1<<i;
				check(i,cnt+1);
				a^=(1<<i);
			}
		}
	}
	public static void setA() {
		a=0;
		a|=1<<('a'-'a');
		a|=1<<('c'-'a');
		a|=1<<('i'-'a');
		a|=1<<('n'-'a');
		a|=1<<('t'-'a');
	}
}