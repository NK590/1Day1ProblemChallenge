import sys

input = sys.stdin.readline

# BOJ9084 - 동전 (G5)

for _ in range(int(input())):
    n = int(input())
    coins = list(map(int, input().split()))
    m = int(input())

    dp = [0 for _ in range(m+1)]
    dp[0] = 1

    for val in coins:
        for i in range(1, m+1):
            if i >= val:
                dp[i] += dp[i-val]

    print(dp[m])