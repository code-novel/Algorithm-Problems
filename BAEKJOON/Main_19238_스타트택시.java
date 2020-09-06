import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시{
   public static int dx[]= {-1,0,0,1};
   public static int dy[]= {0,-1,1,0};
   public static int N,M,F;
   public static int[][] map;   //승객의 위치 맵
   public static Dir taxi;   //택시의 위치 좌표
   public static Map<Integer, Dir> sn=new HashMap<Integer, Dir>();   //손님의 목적지 저장
   public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st=new StringTokenizer(br.readLine());
      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      F=Integer.parseInt(st.nextToken());
      map=new int[N+2][N+2];
      for(int i=0;i<N+2;++i) {   //테두리를 벽으로 채움
         Arrays.fill(map[i], 1);
      }
      for(int i=1;i<=N;++i) {
         st=new StringTokenizer(br.readLine());
         for(int j=1;j<=N;++j) {
            map[i][j]=Integer.parseInt(st.nextToken());
         }
      }
      st=new StringTokenizer(br.readLine());
      taxi=new Dir(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
      for(int i=2;i<M+2;++i) {
         st=new StringTokenizer(br.readLine());
         map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=i;
         sn.put(i, new Dir(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
      }
      for(int i=0;i<M;++i){
         int fuel=bfs();      //택시가 M번만큼 손님을 태우면 끝
         if(fuel==Integer.MAX_VALUE) {   //연료가 떨어지면 -1 출력
            F=-1;
            break;
         }else {         //손님을 무사히 데려다 줬을때 연료 증가
            F+=fuel;
         }
      }
      System.out.println(F);
   }
   public static int bfs() {   //손님 찾는 bfs
      if(map[taxi.r][taxi.c]!=0) {   //택시가 있는 위치에 손님이 있을때
         int n=map[taxi.r][taxi.c];
         map[taxi.r][taxi.c]=0;
         int res=move(taxi.r,taxi.c,n);      //res값은 손님을 태우고 움직인 연료를 반환해줌.
         if(res==Integer.MAX_VALUE||F-res<0) return Integer.MAX_VALUE;   //MAX면 목적지 도착 못함.
         else return res;      //손님을 찾는 비용이 0이기 때문에 데려다 준 비용만큼만 더하면 됨.
      }
      boolean isVisited[][]=new boolean[N+2][N+2];   //방문함수.
      Queue<Dir> q=new LinkedList<>();   //BFS에 사용할 Queue
      PriorityQueue<Dir> tmpQ=new PriorityQueue<Dir>(new Comparator<Dir>() {   //손님의 우선순위를 위해 저장할 우선순위 Queue
          @Override
          public int compare(Dir o1, Dir o2) {
             if(o1.r==o2.r) return o1.c-o2.c;
             return o1.r-o2.r;
          }
       });
      int fuel=1;
      isVisited[taxi.r][taxi.c]=true;
      q.add(taxi);
      while(!q.isEmpty()) {
         int q_size=q.size();
         for(int k=0;k<q_size;++k) {
            Dir tmp=q.poll();
            for(int i=0;i<4;++i) {
               int nr=tmp.r+dx[i];
               int nc=tmp.c+dy[i];
               if(!isVisited[nr][nc]&&map[nr][nc]==0) {
                  isVisited[nr][nc]=true;
                  q.add(new Dir(nr,nc));
               }else if(!isVisited[nr][nc]&&map[nr][nc]>1){   //승객 발견
            	  tmpQ.add(new Dir(nr,nc));
               }
            }
         }
         if(!tmpQ.isEmpty()) {
        	 Dir tmp=tmpQ.poll();
        	 int res=move(tmp.r,tmp.c,map[tmp.r][tmp.c]);   //손님을 태우고 이동.
             map[tmp.r][tmp.c]=0;   //손님을 태웠으니 0로 초기화
             if(res==Integer.MAX_VALUE||F-(fuel+res)<0) return Integer.MAX_VALUE;   //목적지에 도달할 수 없음.
             else return res-fuel;   //res값 만큼 이익이 나고 손님을 찾던 비용 fuel을 빼줌.
         }
         fuel++;
         if(F-fuel<0) return Integer.MAX_VALUE;
      }
      return Integer.MAX_VALUE;
   }
   public static int move( int r, int c, int s) {   //손님 태우고 목적지까지 가는 BFS
      Queue <Dir> q= new LinkedList<>();
      Dir departure=new Dir(sn.get(s).r,sn.get(s).c);   //목적지 좌표
      q.add(new Dir(r,c));
      boolean isVisited[][]=new boolean[N+2][N+2];
      isVisited[r][c]=true;
      int fuel=1;
      while(!q.isEmpty()) {
         int q_size=q.size();
         for(int k=0;k<q_size;++k) {
            Dir tmp=q.poll();
            for(int i=0;i<4;++i) {
               int nr=tmp.r+dx[i];
               int nc=tmp.c+dy[i];
               if(nr==departure.r&&nc==departure.c) {   //목적지에 도착하면 목적지까지 가는데 드는 연료 return
                  taxi=new Dir(departure.r,departure.c);
                  return fuel;
               }
               else if(!isVisited[nr][nc]&&map[nr][nc]!=1) {
                  isVisited[nr][nc]=true;
                  q.add(new Dir(nr,nc));
               }
            }
         }
         fuel++;
      }
      return Integer.MAX_VALUE;
   }
   public static class Dir{
      int r;
      int c;
      public Dir(int r, int c) {
         this.r=r;
         this.c=c;
      }
   }
}