package April;
import java.util.*;
// 프로그래머스 lv2 뒤에 있는 큰 수 찾기 
// https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class Jaehyuck_20230413 {
	//배열로 돌리면 시간초
	public static void main(String[] args) {
		int [] numbers = {2,3,3,5}; 
		int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numbers.length;i++){
        	//  앞에 숫자가 크면 인덱스 저
            if(stack.isEmpty() || numbers[i]<numbers[i-1]){
                stack.push(i);
            } else {
            	//위에서부터 인덱스를 꺼내서 숫자 비교후 인덱스 저장 
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

	}

}
