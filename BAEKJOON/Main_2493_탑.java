import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


class Main_2493_탑 {
	public static int N;
    public static void main(String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    N=Integer.parseInt(br.readLine());
	    StringBuilder sb=new StringBuilder();
	    Stack<long[]> stack=new Stack<>();
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    for(int i=1;i<=N;++i){
	    	int v=Integer.parseInt(st.nextToken());
		    while(!stack.empty()){
			    if(stack.peek()[1]>=v){
				    sb.append(stack.peek()[0]).append(" ");
				    break;
			    }
			    stack.pop();
		    }
		    if(stack.isEmpty()){
			    sb.append("0 ");
		    }
		    stack.push(new long[]{i,v});
	    }
        System.out.println(sb.toString());
    }
}