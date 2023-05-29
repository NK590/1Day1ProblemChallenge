import sys
from collections import deque

# BOJ16930 - 달리기 (P3)

input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

n, m, k = map(int, input().split())
grid = [list(input().rstrip()) for _ in range(n)]
x1, y1, x2, y2 = map(int, input().split())
x1, y1, x2, y2 = x1-1, y1-1, x2-1, y2-1

visited = [[-1 for _ in range(m)] for __ in range(n)]
q = deque()

visited[x1][y1] = 0
q.append([x1, y1])

while q:
    x, y = q.popleft()
    cur_count = visited[x][y]

    for j in range(4):
        for i in range(1, k + 1):
            nx = x + i*dx[j]
            ny = y + i*dy[j]

            if 0 > nx or nx >= n or 0 > ny or ny >= m or grid[nx][ny] == '#':
                break

            if visited[nx][ny] == -1:
                visited[nx][ny] = cur_count + 1
                q.append([nx, ny])
            elif visited[nx][ny] == cur_count + 1:
                continue
            else:
                break

print(visited[x2][y2])