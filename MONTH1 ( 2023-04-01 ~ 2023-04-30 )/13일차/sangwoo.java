/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/68935
 *
 *
 * 3진법 뒤집기
 * 문제 설명
 * 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * n은 1 이상 100,000,000 이하인 자연수입니다.
 * 입출력 예
 * n	result
 * 45	7
 * 125	229
 *
 * */
import java.util.Stack;

public class sangwoo {

    public static void main(String[] args) {


        int n = 3;

        System.out.println(solution2(n));

    }


    public static int solution2(int n){
        int result = 0;
        Stack<Integer> numStack = new Stack<>();
        while(n >= 3){
            numStack.push((n%3));
            n = n /3;
        }
        numStack.push(n);

        System.out.println(numStack);
        int i = 0;
        while(!numStack.isEmpty()){
            result += Math.pow(3,i) * numStack.pop();
            i++;
        }
        return result;
    }
}
