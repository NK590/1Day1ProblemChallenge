// 프로그래머스 - 불량 사용자

import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        List<List<String>> list = new ArrayList<>();
        List<Set<String>> list2 = new ArrayList<>();
        List<Set<String>> listSet = new ArrayList<>();
        
        for(int i = 0; i < banned_id.length; i++) {
            String s = banned_id[i];
            List<String> temp = new ArrayList<>();
            
            Loop1 : for(String s2 : user_id) {
                if(s.length() != s2.length())
                    continue;
                    
                for(int j = 0; j < s.length(); j++) {
                    if(s.charAt(j) == '*' || s.charAt(j) == s2.charAt(j)) {
                        
                    } else {
                        continue Loop1;
                    }
                }
                
                temp.add(s2);
            }
            
            list.add(temp);
        }
        
        
        for(String x : list.get(0)) {
            Set<String> set = new HashSet<>();
            set.add(x);
            listSet.add(set);
        }
        
        
        for(int i = 1; i < list.size(); i++) {
            List<String> x = list.get(i);
            
            int size = listSet.size();
            
            for(String y : x) {
                for(int j = 0; j < size; j++) {
                    Set<String> z = listSet.get(j);
                    Set<String> temp = new HashSet<>();
                    temp.addAll(z);
                    temp.add(y);
                    
                    if(!listSet.contains(temp))
                        listSet.add(temp);
                }
            }
            
            while(size-- > 0) {
                listSet.remove(0);
            }
        }
        
        // for(Set<String> x : listSet) {
        //     if(x.size() != banned_id.length) continue;
        //     for(String y : x) {
        //         System.out.print(y + " ");
        //     }
        //     System.out.println();
        // }
        
        // for(List<String> x : list) {
        //     // if(x.size() != banned_id.length) continue;
        //     for(String y : x) {
        //         System.out.print(y + " ");
        //     }
        //     System.out.println();
        // }
        
        
        for(Set<String> z : listSet)  {            
            if(z.size() == banned_id.length) {
                answer++;
            }
        }
        
        return answer;
    }
}
