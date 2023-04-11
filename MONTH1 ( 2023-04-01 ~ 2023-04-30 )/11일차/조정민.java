// 프로그래머스 - 튜플

import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String[]> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        for(String x : s.split("[{}]")) {
            if(x.equals("") || x.equals(","))
                continue;
            
            list.add(x.split(","));            
        }
        
        Collections.sort(list, (o1, o2) -> o1.length - o2.length);
        
        int[] answer = new int[list.size()];
        int cnt = 0;
        
        for(String[] x : list) {            
            for(String y : x) {
                if(set.contains(y)) {
                    continue;
                } else {
                    set.add(y);
                    answer[cnt++] = Integer.valueOf(y);
                }
            }
        }
        
        return answer;
    }
}
