class Solution {
    public int solution(String s) {
		int len = s.length();
		int answer = len;
		if (len == 1)
			return answer;
		for (int i = 1; i <= len / 2; i++) {
			String now, next = "", res = "";
			int num = 1;
			for (int j = 0; j <= len / i; j++) {
				int start = j * i;
				int end = i * (j + 1) > len ? len : i * (j + 1);
				now = next;
				next = s.substring(start, end);
				if (now.equals(next)) {
					num++;
				} else {
					res += (processnum(num) + now);
					num = 1;
				}
			}
			res += (processnum(num) + next);
			answer = Math.min(answer, res.length());
		}
		return answer;
	}

	private String processnum(int num) {
		return num > 1 ? String.valueOf(num) : "";
	}
}