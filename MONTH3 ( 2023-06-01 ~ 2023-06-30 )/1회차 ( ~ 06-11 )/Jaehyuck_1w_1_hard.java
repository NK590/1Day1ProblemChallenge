package June;
// 프로그래머스 lv4 도둑질
// https://school.programmers.co.kr/learn/courses/30/lessons/42897
public class Jaehyuck_1w_1_hard {
		// 1번 케이스 실패 외 나머지는 다성공
		// 아무리 생각해도 1번은 왜틀린지 모르겠음 
	public static void main(String[] args) {
		int answer = 0;
        int [] money = {1, 2, 3, 1};
        int [] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[1];
        // 첫집 털고 마지막집 안털경우 
        for(int i=2;i<money.length-1;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);       
        }
        answer = dp[money.length-2];
        dp[0] = 0;
        // 첫집을 안털고 마지막집 털경우
        for(int i=2;i<money.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]); 
        } 
        answer = Math.max(answer,dp[money.length-1]);
        
        
        System.out.println(answer);

	}

}
