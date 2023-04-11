import sys

input = sys.stdin.readline

# BOJ13141 - Ignition (P5)

n, m = map(int, input().split())
graph = [[sys.maxsize for _ in range(n+1)] for __ in range(n+1)]
graph2 = [[-1 for _ in range(n+1)] for __ in range(n+1)]

for i in range(n+1):
    graph[i][i] = 0

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = min(graph[a][b], c)
    graph[b][a] = min(graph[b][a], c)
    graph2[a][b] = max(graph2[a][b], c)
    graph2[b][a] = max(graph2[b][a], c)

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

ans = sys.maxsize

for k in range(1, n+1):
    temp = 0
    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] == sys.maxsize:
                continue
            remain = graph2[i][j] - (graph[k][j] - graph[k][i])
            if remain > 0:
                temp = max(temp, (remain / 2) + graph[k][j])
    ans = min(ans, temp)

print(ans)