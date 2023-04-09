import sys

input = sys.stdin.readline

# BOJ21940 - 가운데서 만나기 (G3)

n, m = map(int, input().split())
graph = [[sys.maxsize for _ in range(n+1)] for __ in range(n+1)]
for _ in range(m):
    a, b, t = map(int, input().split())
    graph[a][b] = t

for i in range(n+1):
    graph[i][i] = 0

for k in range(n+1):
    for i in range(n+1):
        for j in range(n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

k = int(input())
li = list(map(int, input().split()))
temp = [sys.maxsize]

for i in range(1, n+1):
    sum_temp = 0
    for j in li:
        if sum_temp < graph[i][j] + graph[j][i]:
            sum_temp = graph[i][j] + graph[j][i]
    temp.append(sum_temp)

min_temp = min(temp)
ans = []

for i in range(1, n+1):
    if min_temp == temp[i]:
        ans.append(i)

print(*ans)