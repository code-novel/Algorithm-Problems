import java.util.Scanner;

public class Main_2231_분해합{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int len=(int)(Math.log10(N)+1);
		int ans=0;
		for(int i=(int)(Math.pow(10, len-1))-(int)(Math.pow(10, len-2));i<N;++i) {
			if(calc(i)==N) {
				ans=i;
				break;
			}
		}
		System.out.println(ans);
	}
	public static int calc(int n) {
		int res=n;
		while(n/10!=0||n%10!=0) {
			res+=(n%10);
			n/=10;
		}
		return res;
	}

}
