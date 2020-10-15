import java.util.Scanner;
public class Main_15650_N과M2 {
		static int N,R;
		static int[] numbers; // R개의 수
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			R = sc.nextInt();
			numbers = new int[R];
			combination(1,0);
		}
		
		private static void combination(int index,int count) {
			if(count==R) {
				for(int i=0;i<R;++i) {
					System.out.print(numbers[i]+" ");
				}
				System.out.println();
				return;
			}
			
			if(index<=N) {
				numbers[count] = index;
				combination(index+1,count+1); // 선택
				combination(index+1,count);	// 비선택
			}
		}
}
