import sys

input = sys.stdin.readline

# BOJ11811 - 데스스타 (S3)

n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]
ans = [0 for _ in range(n)]

for i in range(n):
    for j in range(n):
        ans[i] = ans[i] | grid[i][j]

print(*ans)

