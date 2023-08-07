import sys
from collections import deque

input = sys.stdin.readline

# 나이트가 이동 가능한 8방향을 dx, dy로 정의
dx = [2, 1, -1, -2, -2, -1, 1, 2]
dy = [1, 2, 2, 1, -1, -2, -2, -1]

for _ in range(int(input())):
    l = int(input())
    x, y = map(int, input().split())
    a, b = map(int, input().split())

    v = deque([(x, y, 0)])
    chk = [[False for _ in range(l)] for __ in range(l)]
    chk[x][y] = True

    # 나이트 이동을 BFS로 탐색
    # 해당 지점 도착시 이동 카운트 출력후 break
    # 체스판의 크기가 4*4 이상이므로, 모든 칸에 이동 가능함이 보장되어 있음
    while True:
        n = v.popleft()
        count = n[2]

        if n[0] == a and n[1] == b:
            print(count)
            break

        for i in range(8):
            if 0 <= n[0]+dx[i] < l and 0 <= n[1]+dy[i] < l:
                if not chk[n[0]+dx[i]][n[1]+dy[i]]:
                    v.append((n[0]+dx[i], n[1]+dy[i], count+1))
                    chk[n[0]+dx[i]][n[1]+dy[i]] = True