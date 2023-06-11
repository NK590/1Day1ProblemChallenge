from collections import deque

def solution(n, computers):
    answer = 0

    visited = [False for _ in range(n)]

    for i in range(n):
        if not visited[i]:
            answer += 1
            q = deque()
            q.append(i)
            visited[i] = True
            while q:
                x = q.popleft()
                for j in range(n):
                    if computers[x][j] == 1 and not visited[j]:
                        q.append(j)
                        visited[j] = True

    return answer