import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1786_찾기{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();
        int tLength = t.length;
        int pLength = p.length;
        // 1. 실패함수 만들기
        int[] fail = new int[pLength];
        for (int i = 1,j=0; i < pLength; i++) { // i를 접미사 포인터, j를 접두사 포인터
                while(j>0 && p[i]!=p[j]) {
                    j=fail[j-1];
                }
                    
                if (p[i] == p[j])     fail[i] = ++j;
        }
        
        int cnt=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0,j=0; i<tLength; ++i) {    //i=텍스트 포인터, j: 패턴 포인터
            while (j>0 && t[i]!=p[j]) j=fail[j-1];
            
            if (t[i]==p[j]) {    //두 글자 일치
                if (j==pLength-1) {    //일치한 문자가 패턴의 끝이면
                    list.add(i-pLength+2);
                    cnt++;    //결과 카운트 증가
                    j=fail[j];    //j까지 맞은 경우이므로 실패함수 fail[j] 이용하여 j포인터 이동
                }else j++;
            }
        }
        System.out.println(cnt);
        for(int i=0;i<list.size();++i) {
        	System.out.println(list.get(i));
        }
	}

}
