import sys

sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ3977 - 축구 전술 (P4)

def dfs(node, visited, stack):
    visited[node] = True
    for ne in graph[node]:
        if not visited[ne]:
            dfs(ne, visited, stack)
    stack.append(node)


def reverse_dfs(node, visited, stack):
    visited[node] = True
    stack.append(node)
    indegrees[node] = indegree
    for ne in reverse_graph[node]:
        if not visited[ne]:
            reverse_dfs(ne, visited, stack)


t = int(input())

for _ in range(t):
    if _ != 0: input()
    n, m = map(int, input().split())
    graph = [[] for _ in range(n)]
    reverse_graph = [[] for _ in range(n)]
    for __ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        reverse_graph[b].append(a)

    stack = []
    result = []

    visited = [False for _ in range(n)]
    for i in range(n):
        if not visited[i]:
            dfs(i, visited, stack)

    indegree = -1
    indegrees = [-1 for _ in range(n)]
    visited = [False for _ in range(n)]
    while stack:
        scc = []
        node = stack.pop()
        if not visited[node]:
            indegree += 1
            reverse_dfs(node, visited, scc)
            result.append(sorted(scc))

    scc_indegree = [0 for _ in range(indegree + 1)]
    for node in range(n):
        for next_node in graph[node]:
            if indegrees[node] != indegrees[next_node]:
                scc_indegree[indegrees[next_node]] += 1

    count = 0
    temp = []
    for i in range(len(scc_indegree)):
        if scc_indegree[i] == 0:
            for r in result[i]:
                temp.append(r)
            count += 1

    if count == 1:
        for i in sorted(temp):
            if indegrees[i] == 0:
                print(i)
    else:
        print("Confused")
    print()