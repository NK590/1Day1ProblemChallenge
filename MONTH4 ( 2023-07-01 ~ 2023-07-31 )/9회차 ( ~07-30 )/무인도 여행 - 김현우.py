from collections import deque

# 단순 그래프 탐색 문제
# 아래에서는 BFS로 풀었는데 아마 DFS로도 풀릴것
def solution(maps):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    r, c = len(maps), len(maps[0])
    visited = [[False for _ in range(c)] for __ in range(r)]
    answer = []

    # 모든 지도 칸을 전부 탐색
    for i in range(r):
        for j in range(c):
            # 바다가 아니고 아직 탐색 안한 칸일 때 -> 육지이므로 최대 머무를 수 있는 날짜 탐색하려 BFS 돌리기
            if maps[i][j] != 'X' and not visited[i][j]:
                # temp : 해당 섬의 최대 머무를 수 있는 일수
                temp = 0
                q = deque()
                q.append((i, j))

                while q:
                    x, y = q.popleft()
                    if visited[x][y]:
                        continue
                    visited[x][y] = True
                    temp += int(maps[x][y])

                    for k in range(4):
                        nx, ny = x + dx[k], y + dy[k]
                        if 0 <= nx < r and 0 <= ny < c and maps[nx][ny] != 'X' and not visited[nx][ny]:
                            q.append((nx, ny))

                # answer에 저장
                answer.append(temp)

    # answer에 아무것도 없으면 [-1] 리턴, 있으면 정렬해서 리턴
    return sorted(answer) if answer else [-1]