import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17215_볼링점수계산 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int frame = 1;
		int score = 0;
		boolean isStrike = false;
		boolean isSpare = false;
		boolean f_cnt = false;
		for (int i = 0; i < input.length(); ++i) {
			switch (input.charAt(i)) {
			case 'S':
				if (frame >= 10) {
					if (isSpare) {
						score += 10;
						isSpare = false;
					}
					if (isStrike) {
						score += 10;
						isStrike = false;
						isSpare = true;
					}
					score += 10;
				} else {
					if (isSpare) {
						score += 10;
						isSpare = false;
					}
					if (isStrike) {
						score += 10;
						isStrike = false;
						isSpare = true;
					}
					score += 10;
					isStrike = true;
					frame++;
				}
				break;
			case '-':
				if (isSpare) {
					isSpare = false;
				}
				if (isStrike) {
					isStrike = false;
					isSpare = true;
				}
				if (!f_cnt)
					f_cnt = true;
				else {
					frame++;
					f_cnt = false;
				}
				break;
			case 'P':
				int before = input.charAt(i - 1) == '-' ? 0 : input.charAt(i - 1) - '0';
				if (frame >= 10) {
					if (isSpare) {
						score += 10 - before;
						isSpare = false;
					}
					score += 10 - before;
				} else {
					if (isSpare) {
						score += 10 - before;
						isSpare = false;
					}
					score += 10 - before;
					isSpare = true;
					frame++;
					f_cnt = false;
				}
				break;
			default:
				if (isSpare) {
					isSpare = false;
					score += input.charAt(i) - '0';
				}
				if (isStrike) {
					isStrike = false;
					isSpare = true;
					score += input.charAt(i) - '0';
				}
				score += input.charAt(i) - '0';
				if (!f_cnt)
					f_cnt = true;
				else {
					frame++;
					f_cnt = false;
				}
				break;
			}
		}
		System.out.println(score);
	}
}
