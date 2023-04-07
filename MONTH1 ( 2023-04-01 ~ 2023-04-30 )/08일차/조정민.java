// 프로그래머스 - 달리기 경주

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap();
        
        int idx = 0;
        for(String x : players) {
            map.put(x, idx++);
        }
        
        for(String x : callings) {
            int a = map.get(x);
            
            map.put(x, a - 1);
            map.put(players[a - 1], a);
            
            String temp = players[a - 1];
            players[a - 1] = players[a];
            players[a] = temp;
        }
        
        return players;
    }
}
