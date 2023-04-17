// 프로그래머스 - 과제 진행하기

import java.util.*;
import java.text.*;

class Solution {
    public String[] solution(String[][] plans) throws Exception {
        List<String> answer = new ArrayList<>();
        Arrays.sort(plans, (a, b) -> parse(a[1]) - parse(b[1]));        
        Stack<String[]> stack = new Stack<>();        
        
        int nowTime = 0;        
        
        for(int i = 0; i < plans.length; i++) {
            String[] now = plans[i];
            
            if(i < plans.length - 1) {                
                String[] next = plans[i + 1];
                
                System.out.println(now[0]);
                System.out.println(parse(now[1]) + Integer.valueOf(now[2]) + " ::: " + parse(next[1]));
                
                if(parse(now[1]) + Integer.valueOf(now[2]) <= parse(next[1])) {                    
                    nowTime = parse(now[1]) + Integer.valueOf(now[2]);
                    answer.add(now[0]);
                } else {
                    nowTime = parse(next[1]);
                    stack.add(new String[] {now[0], String.valueOf(Integer.valueOf(now[2]) - parse(next[1]) + parse(now[1]))});
                }
                
                while(nowTime < parse(next[1]) && !stack.isEmpty()) {
                    String[] temp = stack.pop();
                    
                    if(nowTime + Integer.valueOf(temp[1]) <= parse(next[1])) {                    
                        nowTime += Integer.valueOf(temp[1]);
                        answer.add(temp[0]);
                    } else {
                        stack.add(new String[] {temp[0], String.valueOf(Integer.valueOf(temp[1]) - parse(next[1]) + nowTime)});
                        nowTime = parse(next[1]);                        
                    }
                } 
            } else {
                answer.add(now[0]);
                
                while(!stack.isEmpty()) {
                    String[] temp = stack.pop();
                    answer.add(temp[0]);
                }
            }
        }        
        
        return answer.toArray(new String[answer.size()]);
    }

    public int parse(String time) {
        String[] str = time.split(":");
        return Integer.valueOf(str[0]) * 60 + Integer.valueOf(str[1]);
    }
}
