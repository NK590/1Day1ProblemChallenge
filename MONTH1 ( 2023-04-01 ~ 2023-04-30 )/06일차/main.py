import sys
from collections import deque

input = sys.stdin.readline

# BOJ2623 - 음악프로그램 (G3)

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
indegree = [0 for _ in range(n + 1)]

for _ in range(m):
    query = list(map(int, input().split()))
    for i in range(1, query[0]):
        graph[query[i]].append(query[i + 1])
        indegree[query[i + 1]] += 1

result = []
q = deque()

for i in range(1, n + 1):
    if indegree[i] == 0:
        q.append(i)

while q:
    now = q.popleft()
    result.append(now)

    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            q.append(i)

if len(result) != n:
    print(0)
else:
    print(*result, sep='\n')