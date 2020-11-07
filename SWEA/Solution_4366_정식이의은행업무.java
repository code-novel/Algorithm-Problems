import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Solution_4366_정식이의은행업무 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;++t) {
            String sec=br.readLine();
            String trd=br.readLine();
            char[] charsec=sec.toCharArray();
            char[] chartrd=trd.toCharArray();
            long[] arr=new long[charsec.length];
            long tmp=0;
            for(int i=0; i<charsec.length;++i) {
                if(charsec[i]=='0') {
                    charsec[i]='1';
                    tmp=ten(charsec,2);
                    charsec[i]='0';
                }
                else {
                    charsec[i]='0';
                    tmp=ten(charsec,2);
                    charsec[i]='1';
                }
                arr[i]=tmp;
            }
            Arrays.sort(arr);
            for(int i=0; i<chartrd.length;++i) {
                if(chartrd[i]=='0') {
                    chartrd[i]='1';
                    tmp=ten(chartrd,3);
                    if(Arrays.binarySearch(arr, tmp)>-1) {
                        break;
                    }
                    chartrd[i]='2';
                    tmp=ten(chartrd,3);
                    if(Arrays.binarySearch(arr, tmp)>-1) {
                        break;
                    }
                    chartrd[i]='0';
                }
                else if(chartrd[i]=='1') {
                    chartrd[i]='0';
                    tmp=ten(chartrd,3);
                    if(Arrays.binarySearch(arr, tmp)>-1) {
                        break;
                    }
                    chartrd[i]='2';
                    tmp=ten(chartrd,3);
                    if(Arrays.binarySearch(arr, tmp)>-1) {
                        break;
                    }
                    chartrd[i]='1';
                }else{
                    chartrd[i]='0';
                    tmp=ten(chartrd,3);
                    if(Arrays.binarySearch(arr, tmp)>-1) {
                        break;
                    }
                    chartrd[i]='1';
                    tmp=ten(chartrd,3);
                    if(Arrays.binarySearch(arr, tmp)>-1) {
                        break;
                    }
                    chartrd[i]='2';
                }
            }
            System.out.println("#"+t+" "+tmp);
        }
    }
 
    public static long ten(char[] c, int num) {
        long longnum=0;
        for(int i=c.length-1;i>-1;--i) {
            longnum+=(c[i]-'0')*Math.pow(num, c.length-1-i);
        }
        return longnum;
    }
}