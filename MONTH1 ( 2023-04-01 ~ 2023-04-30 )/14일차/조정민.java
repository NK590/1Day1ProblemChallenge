// 프로그래머스 - 단어변환

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Arrays.fill(visited, false);
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);        
        
        while(!queue.isEmpty()){ 
            int size = queue.size();
            
            while(size > 0) {
                String now = queue.poll();
                
                if(now.equals(target))
                    return answer;                    
                
                for(int i = 0; i < words.length; i++) {
                    if(visited[i]) continue;
                    
                    int cnt = 0;
                    
                   for(int j = 0; j < now.length(); j++) {
                       if(now.charAt(j) != words[i].charAt(j))
                           cnt++;
                       
                       if(cnt > 1) 
                           break;
                   } 
                    
                    if(cnt == 1) {
                        queue.add(words[i]);
                        visited[i] = true;
                    }
                }

                size--;
            }
            
            answer++;
        }        
        
        return 0;
    }
}
