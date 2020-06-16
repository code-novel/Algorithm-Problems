import java.util.*;

public class Main_1026_보물 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int N=s.nextInt();
		int []A=new int[N];
		int []B=new int[N];
		int sum=0;
		int i;
		for (i=0;i<N;i++)
			A[i]=s.nextInt();
		for (i=0;i<N;i++)
			B[i]=s.nextInt();
		Arrays.sort(A);
		Arrays.sort(B);
		for (i=0;i<N;i++) {
			sum+=A[i]*B[N-i-1];
		}
		System.out.print(sum);
	}
}
