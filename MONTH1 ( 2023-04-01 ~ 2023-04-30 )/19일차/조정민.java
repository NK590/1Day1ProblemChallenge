// 프로그래머스 - 요격 시스템
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = -1;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);        
          
        for(int[] temp : targets) {
            if(temp[0] >= n) {
                answer++;
                n = temp[1];
            }
        }        
        
        return answer;
    }
}
