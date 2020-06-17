import java.util.Arrays;
import java.util.Scanner;

public class Main_1920_수찾기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int n[]=new int[N];
		for(int i=0;i<N;++i) {
			n[i]=sc.nextInt();
		}
		int A=sc.nextInt();
		Arrays.sort(n);
		int a[]=new int[A];
		for(int i=0;i<A;++i) {
			a[i]=sc.nextInt();
			if(Arrays.binarySearch(n, a[i])>-1) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}
