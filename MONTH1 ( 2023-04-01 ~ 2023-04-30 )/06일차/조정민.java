// 프로그래머스 - 짝지어 제거하기

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        // String[] str= s.split("");
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }            
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
