// 프로그래머스 - 합승 택시 요금

import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] dist = new int[n+1][n+1];

        for(int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 10);
            dist[i][i] = 0;
        }

        for(int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                for(int k = 0; k <= n; k++) {
                    if(dist[j][k] > dist[j][i] + dist[i][k])
                        dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist[i][s] + dist[i][a] + dist[i][b]);
            // System.out.println(answer + " : " + i);
        }

        return answer;
    }
}