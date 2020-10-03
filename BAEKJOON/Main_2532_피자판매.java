import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_2532_피자판매 {
	public static int N;
	public static int A, B;
	public static int[] a, b;
	public static int ans=0;
	public static HashMap<Integer, Integer> sumA, sumB;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		a=new int[2*A-1];
		b=new int[2*B-1];
		sumA=new HashMap<>();
		sumB=new HashMap<>();
		for(int i=0;i<A;++i) {
			if(i==A-1) {
				a[i]=Integer.parseInt(br.readLine());
			}else {
				int tmp=Integer.parseInt(br.readLine());
				a[i]=tmp;
				a[i+A]=tmp;
			}
		}
		for(int i=0;i<B;++i) {
			if(i==B-1) {
				b[i]=Integer.parseInt(br.readLine());
			}else {
				int tmp=Integer.parseInt(br.readLine());
				b[i]=tmp;
				b[i+B]=tmp;
			}
		}
		for(int i=1;i<a.length;++i) {
			a[i]+=a[i-1];
		}
		for(int i=1;i<b.length;++i) {
			b[i]+=b[i-1];
		}
		int idx=0;
		for(int i=1;i<A;++i) {
			for(int j=0;j<A;++j) {
				if(sumA.containsKey(a[j+i]-a[j])) {
					sumA.put(a[j+i]-a[j], sumA.get(a[j+i]-a[j])+1);
				}else {
					sumA.put(a[j+i]-a[j], 1);
				}
			}
		}
		sumA.put(a[A-1], 1);
		sumA.put(0, 1);
		for(int i=1;i<B;++i) {
			for(int j=0;j<B;++j) {
				if(sumB.containsKey(b[j+i]-b[j])) {
					sumB.put(b[j+i]-b[j], sumB.get(b[j+i]-b[j])+1);
				}else {
					sumB.put(b[j+i]-b[j], 1);
				}
			}
		}
		sumB.put(b[B-1], 1);
		sumB.put(0, 1);
		Iterator<Integer> it=sumA.keySet().iterator();
		while(it.hasNext()) {
			int aa=it.next();
			int bb=N-aa;
			if(sumB.containsKey(bb)) {
				ans+=sumA.get(aa)*sumB.get(bb);
			}
		}
		System.out.println(ans);
	}
}