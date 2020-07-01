import java.util.Scanner;

public class Main_15649_N과M1{
	static int N, M, numbers[];
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		numbers = new int[M];
		permutation(0,0);
	}

	private static void permutation(int index, int selected) {
		if(index == M) {
			for(int i=0;i<M;++i) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <=N; i++) {
			if((selected & 1<<i)==0) {	// 해당 수가 선택되지 않았다면
			numbers[index]=i;
			permutation(index+1, selected | 1<<i);
			}
		}
	}
}