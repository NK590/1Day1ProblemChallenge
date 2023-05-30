import sys

input = sys.stdin.readline

# BOJ15988 - 1, 2, 3 더하기 3 (S2)

dp = [-1 for _ in range(1000001)]
dp[0] = 1
dp[1] = 1
dp[2] = 2

for i in range(3, 1000001):
    dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009

for _ in range(int(input())):
    print(dp[int(input())])