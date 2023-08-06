import sys
from collections import deque

input = sys.stdin.readline

for _ in range(int(input())):
    m, n, k = map(int, input().split())
    li = [[0 for __ in range(m)] for ___ in range(n)]
    count = 0

    for i in range(k):
        y, x = map(int, input().split())
        li[x][y] = 1

    # bfs를 이용해서 배추벌레 놓기
    for i in range(n):
        for j in range(m):
            if li[i][j] == 1:
                v = deque([[i, j]])
                while v:
                    s = v.popleft()
                    x = s[0]
                    y = s[1]
                    li[x][y] = 0

                    if 0 <= x + 1 < n and 0 <= y < m:
                        if li[x + 1][y] == 1 and [x + 1, y] not in v:
                            v.append([x + 1, y])
                    if 0 <= x - 1 < n and 0 <= y < m:
                        if li[x - 1][y] == 1 and [x - 1, y] not in v:
                            v.append([x - 1, y])
                    if 0 <= x < n and 0 <= y + 1 < m:
                        if li[x][y + 1] == 1 and [x, y + 1] not in v:
                            v.append([x, y + 1])
                    if 0 <= x < n and 0 <= y - 1 < m:
                        if li[x][y - 1] == 1 and [x, y - 1] not in v:
                            v.append([x, y - 1])
                count += 1

    print(count)