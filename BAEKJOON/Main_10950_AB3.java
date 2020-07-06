import java.util.*;

public class Main_10950_AB3 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int N;
		N=s.nextInt();
		int []A=new int [N];
		int []B=new int [N];
		int i;
		for (i=0; i<N;i++) {
			A[i]=s.nextInt();
			B[i]=s.nextInt();
		}
		for (i=0;i<N;i++) {
			
			System.out.println(A[i]+B[i]);
		}
	}
}
