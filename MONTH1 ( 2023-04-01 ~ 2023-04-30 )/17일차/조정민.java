// 프로그래머스 - 괄호 변환

import java.util.*;

class Solution {
    public String solution(String p) {
        
        return fn(p);
    }
    
    public String fn(String p) {
        if(p.length() == 0)
            return p;
        
        
        // 올바른 문자열인지 확인
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        
        // 균형잡힌 괄호 문자열을 만들기 위한 변수
        int a = 0;  // ( 의 수
        int b = 0;  // ) 의 수
        
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                stack.add('(');
                a++;
            }
            else if(p.charAt(i) == ')') {
                if(stack.size() == 0 || stack.peek() != '(') {
                    flag = false;
                    stack.add(')');
                } else {
                    stack.pop();
                }
                
                b++;
            }
            
            if(a == b)
                break;
        }
        
        String u = p.substring(0, a + b);
        String v = p.substring(a + b, p.length());
        
        if(flag) {
            return u + fn(v); 
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(fn(v));
            sb.append(')');
            
            for(int i = 1; i < u.length() - 1; i++) {
                if(u.charAt(i) == '(')
                    sb.append(')');
                else if(u.charAt(i) == ')')
                    sb.append('(');
            }
            
            return sb.toString();
        }
        
    }
}
