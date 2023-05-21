package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/12980
 *
 * */
public class sangwoo {

    public static void main(String[] args) {

        int n = 5;
        System.out.println(solution(n));
    }

    public static int solution(int n){
        int ans = 0;
        while(n > 0){

            ans += n % 2;
            n = n / 2;
        }

        return ans;
    }
}
