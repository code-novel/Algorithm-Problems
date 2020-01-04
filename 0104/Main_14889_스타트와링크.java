package com.ssafy.hw;

import java.util.Scanner;

public class Main_14889_스타트와링크 {

	public static int N;
	public static int [][]S;
	public static int min=Integer.MAX_VALUE;
	public static boolean[] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		S=new int[N+1][N+1];
		visited=new boolean[N+1];
		for(int i=1; i<=N;++i) {
			for(int j=1;j<=N;++j) {
				S[i][j]=sc.nextInt();
			}
		}
		Combi(1,0);
		System.out.println(min);
	}
	static void Combi(int start, int depth) {
        if(depth == N/2) {
            min = Math.min(min, getSum());
            return;
        }
        for(int i=start; i<N+1; i++) {
            if(visited[i] != true) {
                visited[i] = true;		//Start팀
                Combi(i+1, depth+1);
                visited[i] = false;		//Link팀
            }
        }
    }
	static int getSum() {
        int Start = 0;
        int Link = 0;
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                if(visited[i] && visited[j])
                    Start += S[i][j];
                if(visited[i] != true && visited[j] != true)
                    Link += S[i][j];
            }
        }
        return Math.abs(Start - Link);
    }
}
