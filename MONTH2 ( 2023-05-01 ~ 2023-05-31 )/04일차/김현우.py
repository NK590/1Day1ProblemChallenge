import sys

input = sys.stdin.readline

# BOJ12865 - 평범한 배낭 (G5)

n, k = map(int, input().split())
dp = [[0 for _ in range(k+1)] for __ in range(n+1)]

stuff = [[0, 0]] + [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n+1):
    weight, value = stuff[i]
    for j in range(1, k+1):
        if j < weight:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(value + dp[i-1][j-weight], dp[i-1][j])

print(dp[n][k])