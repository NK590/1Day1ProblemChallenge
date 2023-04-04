// 프로그래머스 - 피로도

import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) throws Exception {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        Arrays.fill(visited, false);
        
        for(int i = 0; i < dungeons.length; i++) {
            visited[i] = true;
            answer = Math.max(fn(k, dungeons, i, visited, 1), answer);
            visited[i] = false;
        }
        
        return answer;
    }
    
    public int fn(int k, int[][] dungeons, int c, boolean[] visited, int cnt) {
        // System.out.println("depth = " + cnt + " dungeons = " + c + " k = " + k);
        
        if(k < dungeons[c][0])
            return cnt - 1;
        
        if(cnt == dungeons.length)
            return cnt;
        
        int max = 0;
        k -= dungeons[c][1];
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            max = Math.max(fn(k, dungeons, i, visited, cnt + 1), max);
            visited[i] = false;
        }            
        
        k += dungeons[c][1];
        
        return max;
    }
}
