import sys
from heapq import heappush, heappop

# 통과 못한 코드인데 일단 짠 데까지 올려봅니다
# 아마 아이디어는 이게 맞을거...

input = sys.stdin.readline

def dijkstra(graph, start):
    distances = {node : sys.maxsize for node in graph}
    distances[start] = 0
    q = []
    heappush(q, [distances[start], start])

    while q:
        cur_distance, cur_destination = heappop(q)
        if distances[cur_destination] < cur_distance:
            continue

        for next_destination, next_distance in graph[cur_destination].items():
            distance = cur_distance + next_distance
            if distance < distances[next_destination]:
                distances[next_destination] = distance
                heappush(q, [distance, next_destination])

    return distances

def dijkstra2(graph, start):
    distances = {node : sys.maxsize for node in graph}
    distances[start] = 0
    q = []
    heappush(q, [distances[start], start, True])

    while q:
        cur_distance, cur_destination, cur_status = heappop(q)
        next_weight = 0.5 if cur_status else 2

        for next_destination, next_distance, in graph[cur_destination].items():
            distance = cur_distance * next_weight + next_distance
            if distance < distances[next_destination]:
                distances[next_destination] = distance
                heappush(q, [distance, next_destination, not cur_status])

    return distances

n, m = map(int, input().split())
graph = {node : {} for node in range(1, n+1)}
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c

di_1 = dijkstra(graph, 1)
di_2 = dijkstra2(graph, 1)
count = 0

for node in range(1, n+1):
    if di_1[node] < di_2[node]:
        count += 1

print(count)