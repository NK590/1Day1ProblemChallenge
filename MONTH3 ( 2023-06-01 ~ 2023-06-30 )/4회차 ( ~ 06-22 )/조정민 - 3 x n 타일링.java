class Solution {
    public int solution(int n) {
        // n 이 짝수일 때만 모든 칸을 채울 수 있다.
        // 가로 길이가 2 일 때 경우의 수는 3
        // 가로 길이가 4 일 때 경우의 수는 11, 그 중에 길이가 4 일때만 가능한 경우는 2 개
        // 3 * 3 + 2 = 11
        // 3 * 11 + 3 * 2 + 2 = 41
        // 41 * 3 + 11 * 2 + 3 * 2 + 2 = 153

        long[] dp = new long[n + 2];
        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i += 2) {
            int num = i - 2;
            dp[i] = (dp[num] * 3) % 1000000007;
            num -= 2;

            while(num >= 0) {
                dp[i] += (dp[num] * 2) % 1000000007;
                dp[i] %= 1000000007;
                num -= 2;
            }

            dp[i] %= 1000000007;
        }

        return (int) dp[n];
    }
}
