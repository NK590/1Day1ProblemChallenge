package April;
import java.util.*;
// 프로그래머스 lv2 짝지어 제거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12973#

public class Jaehyuck_20230426 {

	public static void main(String[] args) {
		String s = "baabaa";
		int answer = 0;
        Stack<Character> stack = new Stack<>();
        // 홀수인경우 무조건 실패 
        if(s.length() % 2 != 0)// return 0;
        // 하나씩 쌓아가면서 비교 
        for(int i=0;i<s.length()-1;i++){
            stack.push(s.charAt(i));
            while(!stack.isEmpty()){
                if(stack.peek() == s.charAt(i+1)){
                    stack.pop();
                    i++;
                } else{
                    break;
                }
            }
        }
        if(!stack.isEmpty()) answer =0;
      //  return answer;
	}

}
