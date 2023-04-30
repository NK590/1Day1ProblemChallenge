// 프로그래머스 - 삼총사

import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        
        for(int x : number) {
            int size = list.size();
            
            for(int i = 0; i < size; i++) {
                List<Integer> temp = list.get(i);
                
                if(temp.size() >= 3)
                    continue;
                
                List<Integer> temp2 = new ArrayList<>(temp);
                temp2.add(x);
                list.add(temp2);
            }
        }
        
        for(List<Integer> x : list) {
            if(x.size() != 3)
                continue;
            
            int sum = 0;
            
            for(Integer y : x) {
                sum += y;
            }

            if(sum == 0)
                answer++;
        }
        
        return answer;
    }
}
