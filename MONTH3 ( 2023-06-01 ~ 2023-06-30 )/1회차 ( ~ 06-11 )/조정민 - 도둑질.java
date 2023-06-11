import java.util.*;

class Solution {
    // 인접한 집은 털 수 없기 때문에 
    // dp[n] = Max(dp[n - 1], dp[n - 2] + arr[n]); (틀림)
    //     [1000, 10, 10, 2000, 30] 2 개를 띄우고 선택하는 경우도 있어서 dp[n -3] + arr[n] 까지 고려해야한다.
    // 원형으로 이루어져 있기 때문에 0번 집을 턴 경우와 털지 않은 경우 2가지를 경우를 구현
    
    public int solution(int[] money) {
        int answer = 0;
        
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        
        // 0 번 집을 턴 경우 = 마지막 집은 털 수 없다.
        dp1[0] = money[0];
        dp1[2] = money[2] + dp1[0];
        
        for(int i = 3; i < money.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], Math.max(dp1[i -2], dp1[i -3]) + money[i]);
        }
         
        
        // 0 번 집을 털지 않은 경우
        dp2[1] = money[1];
        dp2[2] = Math.max(money[1], money[2]);
        
        for(int i = 3; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], Math.max(dp2[i -2], dp2[i -3]) + money[i]);
        }
        
        return Math.max(dp1[money.length - 2], dp2[money.length - 1]);
    }
}
