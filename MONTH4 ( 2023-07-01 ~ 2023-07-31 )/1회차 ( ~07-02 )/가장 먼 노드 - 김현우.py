from collections import deque


def solution(n, edge):
    answer = 0
    # 1번 노드에서의 거리
    distance = [0 for _ in range(n + 1)]
    q = deque()
    graph = [[] for _ in range(n + 1)]

    # 기존 edge 정보를 그래프화
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    # 시작점을 1로 잡고 BFS 탐색
    q.append(1)
    distance[1] = 1

    # BFS 탐색하면서 1에서부터 각 노드의 최단거리 갱신
    while q:
        node = q.popleft()
        for g in graph[node]:
            if distance[g] == 0:
                q.append(g)
                distance[g] = distance[node] + 1

    # 최대 거리인 노드만 뽑아서 카운트
    max_distance = max(distance)
    for d in distance:
        if d == max_distance:
            answer += 1

    return answer
