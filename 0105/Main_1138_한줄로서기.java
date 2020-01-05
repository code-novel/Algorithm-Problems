

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int leftCount;
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			leftCount = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				if (leftCount == 0 && arr[j] == 0) {
					arr[j] = i + 1;
					break;
				} else if (arr[j] == 0) {
					leftCount--;
				}
			}
		}
		for (int d : arr) {
			System.out.print(d + " ");
		}
	}
}
