package April;
// 프로그래머스 Lv2 피보나치 수
// https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class Jaehyuck_20230416 {

	public static int main(String[] args) {
		int n =3;
		int answer = 0;
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
           if(dp[i] >= 1234567) dp[i] = dp[i] % 1234567;
        }
        
        return dp[n];

	}

}
