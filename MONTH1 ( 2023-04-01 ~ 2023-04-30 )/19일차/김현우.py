import sys
from collections import deque

input = sys.stdin.readline

# BOJ13903 - 출근 (S1)

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]
direction = [list(map(int, input().split())) for _ in range(int(input()))]
len_dir = len(direction)
visited = [[False for _ in range(m)] for __ in range(n)]
q = deque()

for i in range(m):
    if grid[0][i] == 1:
        visited[0][i] = True
        q.append([0, i, 0])

while q:
    x, y, count = q.popleft()
    if x == n-1:
        print(count)
        exit(0)

    for j in range(len_dir):
        dx, dy = direction[j]
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if grid[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny, count + 1])

print(-1)