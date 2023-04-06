import sys

input = sys.stdin.readline

# BOJ11562 - 백양로 브레이크 (G3)

n, m = map(int, input().split())
graph = [[sys.maxsize for _ in range(n)] for __ in range(n)]
for _ in range(m):
    u, v, b = map(int, input().split())
    if b == 0:
        graph[u-1][v-1] = 0
        graph[v-1][u-1] = 1
    elif b == 1:
        graph[u-1][v-1] = 0
        graph[v-1][u-1] = 0

for i in range(n):
    graph[i][i] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

for _ in range(int(input())):
    s, e = map(int, input().split())
    print(graph[s-1][e-1])