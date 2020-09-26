import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226_이모티콘{
	public static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		Queue<Emoticon> q=new LinkedList<>();
		boolean[][] isVisited=new boolean[1001][1001];
		isVisited[1][0]=true;
		q.add(new Emoticon(1,0));
		int time=1;
		out : while(!q.isEmpty()) {
			int q_size=q.size();
			for(int i=0;i<q_size;++i) {
				Emoticon tmp=q.poll();
				if(!isVisited[tmp.val][tmp.val]) q.add(new Emoticon(tmp.val,tmp.val));	//복사
				if(tmp.val+tmp.clipboard==N)break out;	//붙여넣기
				else {
					int newVal=tmp.val+tmp.clipboard;
					if(newVal<1001&&!isVisited[newVal][tmp.clipboard]) {
						isVisited[newVal][tmp.clipboard]=true;
						q.add(new Emoticon(newVal,tmp.clipboard));
					}
				}
				if(tmp.val-1==N)break out;
				else if(tmp.val-1>0){
					int newVal=tmp.val-1;
					if(newVal<1001&&!isVisited[newVal][tmp.clipboard]) {
						isVisited[newVal][tmp.clipboard]=true;
						q.add(new Emoticon(newVal,tmp.clipboard));
					}
				}
			}
			time++;
		}
		System.out.println(time);
	}
	public static class Emoticon{
		int val;	//현재 화면의 이모티콘 개수
		int clipboard;	//클립보드에 들어있는 이모티콘 개수
		public Emoticon(int v, int c) {
			this.val=v;
			this.clipboard=c;
		}
	}
}