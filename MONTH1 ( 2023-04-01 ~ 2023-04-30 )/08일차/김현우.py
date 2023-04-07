import sys
from collections import deque

input = sys.stdin.readline

# BOJ1516 - 게임 개발 (G3)

n = int(input())
graph = [[] for _ in range(n+1)]
time = [0 for _ in range(n+1)]
indegree = [0 for _ in range(n+1)]

for i in range(1, n+1):
    query = list(map(int, input().split()))
    time[i] = query[0]

    for j in range(1, len(query)-1):
        graph[query[j]].append(i)
        indegree[i] += 1

result = [0 for _ in range(n+1)]
q = deque()

for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)

while q:
    now = q.popleft()
    result[now] += time[now]
    for i in graph[now]:
        indegree[i] -= 1
        result[i] = max(result[i], result[now])
        if indegree[i] == 0:
            q.append(i)

print(*result[1:], sep='\n')
