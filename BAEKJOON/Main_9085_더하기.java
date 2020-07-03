import java.util.*;

public class Main_9085_더하기 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int T;
		T=s.nextInt();
		int []N=new int[10];
		int [][]Num=new int [10][100];
		int []sum=new int[T];
		int i, j;
		for(i=0;i<T;i++) {
			N[i]=s.nextInt();
			for(j=0;j<N[i];j++) {
				Num[i][j]=s.nextInt();
				sum[i]+=Num[i][j];
			}
		}
		for (i=0;i<T;i++)
			System.out.println(sum[i]);
		
				
	}
}
