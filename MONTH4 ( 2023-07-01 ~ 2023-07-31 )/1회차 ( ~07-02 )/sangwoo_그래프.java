package examplenote;

import java.util.LinkedList;
import java.util.Queue;

public class Example49189 {

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n,edge));


    }

    public static int solution(int n, int[][] edge){

        int[] dist = new int[n+1];

        boolean[][] map = new boolean[n+1][n+1];
        for(int i = 0; i < edge.length; i++){
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int maxDist = 0;
        while(!queue.isEmpty()){

            int i = queue.poll();

            for(int j = 2; j <=n; j++){
                if(dist[j] == 0 && map[i][j]){
                    dist[j] = dist[i] + 1;
                    maxDist = Math.max(maxDist, dist[j]);
                }
            }
        }

        int result = 0;
        for(int num : dist){
            if(maxDist == num){
                result++;
            }
        }
        return  result;
    }
}
