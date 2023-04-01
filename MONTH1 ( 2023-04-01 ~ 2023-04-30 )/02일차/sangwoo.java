import java.util.*;

/**
 *
 *  url : https://school.programmers.co.kr/learn/courses/30/lessons/77884
 *
 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

 제한사항
 1 ≤ left ≤ right ≤ 1,000
 *
 * */
public class sangwoo{

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,6,7,8,0};

        System.out.println(solution(numbers));
    }

    public static int solution(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++){
            int tmp  = measureCnt(i);
            if(measureCnt(i) % 2 == 0){
                result += i;
            }else{
                result -= i;
            }
        }

        return result;
    }

    public static int measureCnt(int n ){

        int cnt = 0;
        for(int i = 1; i * i <= n;i++) {
            if (i * i == n) {
                cnt++;
            }else if(n % i == 0) cnt +=2;
        }
        return cnt;
    }


}

