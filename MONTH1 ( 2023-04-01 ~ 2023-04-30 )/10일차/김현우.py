import sys

input = sys.stdin.readline

# BOJ12875 - 칙령 (G4)

n, d = int(input()), int(input())
grid = [list(input().rstrip()) for _ in range(n)]
graph = [[sys.maxsize for _ in range(n)] for __ in range(n)]

for i in range(n):
    graph[i][i] = 0

for i in range(n):
    for j in range(n):
        if grid[i][j] == 'Y':
            graph[i][j] = d

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

max_val = max([max(graph[i]) for i in range(n)])
print(-1 if max_val == sys.maxsize else max_val)