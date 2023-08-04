from collections import deque

play = int(input())

xm = [-1, 0, 1, 0]
ym = [0, 1, 0, -1]

for i in range(play):
    x, y, k = map(int, input().split())
    result = 0
    visited = []
    graph = []
    queue = deque()

    for j in range(k):
        a, b = map(int, input().split())
        graph.append([a, b])

    for j in graph:
        if j not in visited:
            visited.append(j)
            queue.append(j)
            result += 1

            # print(j)

            while queue:
                t = queue.popleft()
                for k in range(4):
                    xn = t[0] + xm[k]
                    yn = t[1] + ym[k]
                    target = [xn, yn]
                    if xn >= 0 and xn < x and yn >= 0 and yn < y and target in graph and target not in visited and target not in queue:
                        visited.append(target)
                        queue.append(target)

    print(result)
