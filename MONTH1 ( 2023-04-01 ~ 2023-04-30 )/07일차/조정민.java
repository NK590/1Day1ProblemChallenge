// 프로그래머스 - 카드 뭉치

import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int a = 0;
        int b = 0;
        
        for(String x : goal) {
            if(a < cards1.length && x.equals(cards1[a])) {
                a++;
            } else if(b < cards2.length && x.equals(cards2[b])) {
                b++;
            } else {
                return "No";
            }
        }       
        
        return "Yes";
    }
}
