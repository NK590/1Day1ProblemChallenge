import sys

input = sys.stdin.readline

# BOJ3980 - 선발 명단 (G5)

def backtrack(i, sum_val):
    global max_val
    if i == 11:
        max_val = max(max_val, sum_val)
        return

    for j in range(11):
        if grid[i][j] != 0 and not visited[j]:
            visited[j] = True
            backtrack(i+1, sum_val + grid[i][j])
            visited[j] = False

for _ in range(int(input())):
    grid = [list(map(int, input().split())) for _ in range(11)]
    max_val = 0
    visited = [False for _ in range(11)]
    backtrack(0, 0)
    print(max_val)
