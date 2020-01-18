import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17826_나의학점은 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		Integer []a=new Integer [50];
		for(int i=0;i<50;++i) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int b=Arrays.binarySearch(a, Integer.parseInt(br.readLine()));
		if(b<2) {
			System.out.println("F");
		}else if(b<5) {
			System.out.println("C0");
		}else if(b<15) {
			System.out.println("C+");
		}else if(b<20) {
			System.out.println("B0");
		}else if(b<35) {
			System.out.println("B+");
		}else if(b<45) {
			System.out.println("A0");
		}else {
			System.out.println("A+");
		}
	}

}
