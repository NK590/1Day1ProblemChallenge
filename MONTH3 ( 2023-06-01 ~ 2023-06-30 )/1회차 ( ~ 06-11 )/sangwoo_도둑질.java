package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/42897
 *
 * */
public class Example42897_ {

    public static void main(String[] args) {

        int[] money = {1,2,3,1,1000,5,7,2,4,2000};
        System.out.println(solution(money));
    }

    public static int solution(int[] money){

        int[][] dp = new int[2][money.length];

        // [0][] 처음부터 시작
        // [1][] 처음 없이 시작
        // 원형이라 처음과 끝이 만나면 안되어서 2가지 조건으로 계산

        dp[0][0]=money[0];
        dp[0][1]=money[0];
        dp[0][2]=Math.max(dp[0][1],dp[0][0]+money[2]);// 원형 처음 시작


        dp[1][1]=money[1];
        dp[1][2]=Math.max(dp[1][1],money[2]); // 처음을 날리고 시작

        // 마지막값 계산 안함
        for(int i=3;i<money.length-1;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[0][i-2]+money[i]);
            dp[1][i]=Math.max(dp[1][i-1],dp[1][i-2]+money[i]);
        }
        dp[1][money.length-1]=Math.max(dp[1][money.length-2],dp[1][money.length-3]+money[money.length-1]); // 마지막값 계산

        return Math.max(dp[0][money.length-2],dp[1][money.length-1]);// 처음 날린거와 처음 시작인거와 비교

    }
}
