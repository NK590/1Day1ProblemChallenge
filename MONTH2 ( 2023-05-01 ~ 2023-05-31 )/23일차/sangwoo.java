package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/12985
 *
 * */
public class sangwoo {


    public static void main(String[] args) {

        int N = 8;
        int A = 4;
        int B = 7;
        System.out.println(soluton(N,A,B));
    }

    public static int soluton(int n , int a, int b){
        int result = 1;

        while(Math.abs(a-b) != 1 || Math.max(a,b) % 2 != 0 ){
            a = (a+1) /2;
            b = (b+1) /2;
            result++;
        }

        return result;
    }
}
