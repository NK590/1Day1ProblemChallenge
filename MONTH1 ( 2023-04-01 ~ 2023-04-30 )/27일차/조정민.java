// 연속 부분 수열 합의 개수
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        // 길이
        for(int i = 1; i <= elements.length; i++) {
            // 시작 지점
            for(int j = 0; j < elements.length; j++) {
                int sum = 0;
                
                for(int k = j; k < elements.length && k - j < i; k++) {
                    sum += elements[k];
                }
                
                for(int k = 0; k < i - elements.length + j; k++) {
                    sum += elements[k];
                }
                
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
