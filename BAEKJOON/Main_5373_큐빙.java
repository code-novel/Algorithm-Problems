import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;++tc) {
			char [][]top={{'w','w','w'},{'w','w','w'},{'w','w','w'}};
			char [][]bot={{'y','y','y'},{'y','y','y'},{'y','y','y'}};
			char [][]front={{'r','r','r'},{'r','r','r'},{'r','r','r'}};
			char [][]back={{'o','o','o'},{'o','o','o'},{'o','o','o'}};
			char [][]left={{'g','g','g'},{'g','g','g'},{'g','g','g'}};
			char [][]right={{'b','b','b'},{'b','b','b'},{'b','b','b'}};
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;++i) {
				String s=st.nextToken();
				Cubing(top,bot,front,back,left,right,s);
			}
			for(int i=0;i<3;++i) {
				for(int j=0;j<3;++j) {
					System.out.print(top[i][j]);
				}
				System.out.println();
			}
		}
	}
	public static void Cubing(char[][]top,char[][]bot,char[][]front,char[][]back,char[][] left,char[][] right, String s) {//0 : 윗 1 : 아래 2: 앞 3 : 뒤 4:왼 5 : 오른
		char[] tmp=new char[3];
		switch(s){
			case "U+":
				tmp=front[0].clone();
				front[0]=right[0].clone();
				right[0]=back[0].clone();
				back[0]=left[0].clone();
				left[0]=tmp.clone();
				turn(top,s.charAt(1));
				break;
			case "U-":
				tmp=front[0].clone();
				front[0]=left[0].clone();
				left[0]=back[0].clone();
				back[0]=right[0].clone();
				right[0]=tmp.clone();
				turn(top,s.charAt(1));
				break;
			case "D+":
				tmp=front[2].clone();
				front[2]=left[2].clone();
				left[2]=back[2].clone();
				back[2]=right[2].clone();
				right[2]=tmp.clone();
				turn(bot,s.charAt(1));
				break;
			case "D-":
				tmp=front[2].clone();
				front[2]=right[2].clone();
				right[2]=back[2].clone();
				back[2]=left[2].clone();
				left[2]=tmp.clone();
				turn(bot,s.charAt(1));
				break;
			case "F+":
				tmp=top[2].clone();
				for(int i=0;i<3;++i) {
					top[2][i]=left[2-i][2];
					left[2-i][2]=bot[0][2-i];
					bot[0][2-i]=right[i][0];
					right[i][0]=tmp[i];
				}
				turn(front,s.charAt(1));
				break;
			case "F-":
				tmp=top[2].clone();
				for(int i=0;i<3;++i) {
					top[2][i]=right[i][0];
					right[i][0]=bot[0][2-i];
					bot[0][2-i]=left[2-i][2];
					left[2-i][2]=tmp[i];
				}
				turn(front,s.charAt(1));
				break;
			case "B+":
				tmp=top[0].clone();
				for(int i=0;i<3;++i) {
					top[0][i]=right[i][2];
					right[i][2]=bot[2][2-i];
					bot[2][2-i]=left[2-i][0];
					left[2-i][0]=tmp[i];
				}
				turn(back,s.charAt(1));
				break;
			case "B-":
				tmp=top[0].clone();
				for(int i=0;i<3;++i) {
					top[0][i]=left[2-i][0];
					left[2-i][0]=bot[2][2-i];
					bot[2][2-i]=right[i][2];
					right[i][2]=tmp[i];
				}
				turn(back,s.charAt(1));
				break;
			case "L+":
				for(int i=0;i<3;++i) {
					tmp[i]=top[i][0];
					top[i][0]=back[2-i][2];
					back[2-i][2]=bot[i][0];
					bot[i][0]=front[i][0];
					front[i][0]=tmp[i];
				}
				turn(left,s.charAt(1));
				break;
			case "L-":
				for(int i=0;i<3;++i) {
					tmp[i]=top[i][0];
					top[i][0]=front[i][0];
					front[i][0]=bot[i][0];
					bot[i][0]=back[2-i][2];
					back[2-i][2]=tmp[i];
				}
				turn(left,s.charAt(1));
				break;
			case "R+":
				for(int i=0;i<3;++i) {
					tmp[i]=top[i][2];
					top[i][2]=front[i][2];
					front[i][2]=bot[i][2];
					bot[i][2]=back[2-i][0];
					back[2-i][0]=tmp[i];
				}
				turn(right,s.charAt(1));
				break;
			case "R-":
				for(int i=0;i<3;++i) {
					tmp[i]=top[i][2];
					top[i][2]=back[2-i][0];
					back[2-i][0]=bot[i][2];
					bot[i][2]=front[i][2];
					front[i][2]=tmp[i];
				}
				turn(right,s.charAt(1));
				break;
		}
	}
	public static void turn(char[][] a,char d) {	//a->b b->c c->d d->a 순으로
		char[][]tmp=new char[3][3];
		if(d=='+') {
			for(int i=0;i<3;++i) {
				for(int j=0;j<3;++j) {
					tmp[j][2-i]=a[i][j];
				}
			}
		}
		else {
			for(int i=0;i<3;++i) {
				for(int j=0;j<3;++j) {
					tmp[2-j][i]=a[i][j];
				}
			}
		}
		for(int i=0;i<3;++i) {
			for(int j=0;j<3;++j) {
				a[i][j]=tmp[i][j];
			}
		}
	}
}