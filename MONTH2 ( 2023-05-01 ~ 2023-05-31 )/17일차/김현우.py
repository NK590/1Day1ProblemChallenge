import sys
from collections import deque

input = sys.stdin.readline

# BOJ12761 - 돌다리 (S1)

a, b, n, m = map(int, input().split())
q = deque()
visited = [False for _ in range(100001)]
jump = [-1, 1, -a, a, -b, b]
jump2 = [a, b]

q.append((n, 0))
visited[n] = True

while q:
    pos, count = q.popleft()
    if pos == m:
        print(count)
        exit(0)

    for entry in jump:
        if 0 <= pos + entry <= 100000 and not visited[pos + entry]:
            visited[pos + entry] = True
            q.append((pos + entry, count + 1))

    for entry in jump2:
        if pos * entry <= 100000 and not visited[pos * entry]:
            visited[pos * entry] = True
            q.append((pos * entry, count + 1))
