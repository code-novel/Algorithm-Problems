import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1075_나누기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int F=Integer.parseInt(br.readLine());
		if(N>99) {
			for(int i=N/100*100;i<(N/100+1)*100;++i) {
				if(i%F==0) {
					if(i%100<10) {
						System.out.print("0");
						System.out.println(i%100);
					}else {
						System.out.println(i%100);
					}
					break;
				}
			}
		}else {
			if(F<10) {
				System.out.print("0");
				System.out.println(F);
			}else {
				System.out.println(F);
			}
		}
	}
}
