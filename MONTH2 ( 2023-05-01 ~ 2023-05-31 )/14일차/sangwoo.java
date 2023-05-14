package examplenote;

/**
 *
 * url  : https://school.programmers.co.kr/learn/courses/30/lessons/12940
 *
 * */
public class sangwoo {


    public static void main(String[] args) {

        int n = 3;
        int m = 12;

        System.out.println(solution(n,m));

    }

    public static int[] solution(int n, int m){



        int  commonFactor = gcd(n, m);

        int[] result = new int[2];
        result[0] = commonFactor;
        result[1] =  m * n / commonFactor;

        return result;

    }

    public static int gcd(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
