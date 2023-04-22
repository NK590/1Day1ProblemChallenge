import sys

input = sys.stdin.readline

# BOJ23039 - 시식 코너는 나의 것 (S1)

n = int(input())
li = [int(input()) for _ in range(n)]

dp = [[0, 0, 0] for _ in range(n)]
dp[0] = [0, li[0] // 2, li[0]]
if n > 1:
    dp[1][0] = li[0]
    dp[1][1] = li[0] + li[1] // 2
    dp[1][2] = li[1]

for i in range(2, n):
    dp[i][0] = max(dp[i-1][0], max(dp[i-1][1], dp[i-1][2]))
    dp[i][1] = dp[i-1][2] + li[i] // 2
    dp[i][2] = dp[i-1][0] + li[i]

print(max(dp[-1]))