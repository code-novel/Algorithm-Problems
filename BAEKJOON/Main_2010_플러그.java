import java.util.*;

public class Main_2010_플러그 {
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int sum=0;
		int N=s.nextInt();
		for (int i=0;i<N;i++) {
			int temp=s.nextInt();
			if(i==0)
				sum+=temp;
			else
				sum+=temp-1;
		}
		System.out.print(sum);
	}
}
