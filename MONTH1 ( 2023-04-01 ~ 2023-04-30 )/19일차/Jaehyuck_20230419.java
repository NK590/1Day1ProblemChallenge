package April;
//프로그래머스 lv2 올바른 괄호
//https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Jaehyuck_20230419 {

	public static void main(String[] args) {
			String s = "()()";
		 	boolean answer = true;
	        int n =0;
	        // ) 가 더많아지거나 (,) 갯수가 맞지 않으면 false
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i) == '(') n++;
	            else n--;
	            
	            if(n == -1){
	                answer = false;
	                break;
	            }
	        }
	        
	        if( n != 0) answer = false;
	        
	        System.out.println(answer);
	}

}
