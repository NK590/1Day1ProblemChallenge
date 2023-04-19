package April;
import java.util.*;

public class Jaehyuck_20230420 {

	public static void main(String[] args) {
		String s = "[](){}";
		int answer = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        sb.append(s);
         for(int i=0;i<s.length();i++){
            stack.clear();
            for(int j=0;j<s.length();j++){
                 if(stack.isEmpty()){
                    stack.push(sb.toString().charAt(j));
                     continue;
                 }
                 //닫히는 괄호인지 확인 
                if(sb.toString().charAt(j) == '['  ||  sb.toString().charAt(j) == '{' ||  sb.toString().charAt(j) == '('){
                  stack.push(sb.toString().charAt(j));
                }else if( sb.toString().charAt(j) == ']'){
                	if(stack.peek() == '['){
                      stack.pop();
                	} else {
                      break;
                	}
                }else if(sb.toString().charAt(j) == '}'){
                	if(stack.peek() == '{'){
                      stack.pop();
                	} else {
                      break;
                	}
                }else {
                 if(stack.peek() == '('){
                      stack.pop();
                  } else {
                      break;
                  } 
              }
           }
            if(stack.isEmpty()) answer++;
          
            sb.insert(0,sb.toString().charAt(sb.length()-1));
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(answer);

	}

}
