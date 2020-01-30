import java.util.Scanner;

public class Main {

	static int[][] top=new int[5][8];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
			for(int i=1;i<=4;++i) {
                String s=sc.nextLine();
				for(int j=0;j<8;++j) {
					top[i][j]=s.charAt(j)-'0';
				}
			}
        	int K=sc.nextInt();
			for(int i=0;i<K;++i) {
				int num=sc.nextInt();
				int pos=sc.nextInt();
				rotate(num,pos);
			}
			int ans=0;
			for(int i=1;i<5;++i) {
				ans+=top[i][0]*Math.pow(2, i-1);
			}
			System.out.println(ans);
	}
	static void rotate(int num, int pos) {
		int start=4;
		int end=1;
		if(num>1) {
			for(int i=num-1;i>0;--i) {
				if(top[i+1][6]==top[i][2]) {
					break;
				}
				start=start>i?i:start;
			}
		}
		if(num<4) {
			for(int i=num+1;i<5;++i) {
				if(top[i-1][2]==top[i][6]) {
					break;
				}
				end=end<i?i:end;
			}
		}
		int tmp=pos;
		swap(num, pos);
		if(num>1) {
			for(int i=num-1;i>=start;--i) {
				pos*=-1;
				swap(i, pos);
			}
		}
		if(num<4) {
			for(int i=num+1;i<=end;++i) {
				tmp*=-1;
				swap(i, tmp);
			}
		}
	}
	static void swap(int a, int b) {
		int tmp=0;
		int tmp2=0;
		if(b==-1) {
			tmp=top[a][0];
			for(int i=7;i>-1;--i) {
				tmp2=top[a][i];
				top[a][i]=tmp;
				tmp=tmp2;
			}
		}else if (b==1) {
			tmp=top[a][7];
			for(int i=0;i<8;++i) {
				tmp2=top[a][i];
				top[a][i]=tmp;
				tmp=tmp2;
			}
		}
	}
}