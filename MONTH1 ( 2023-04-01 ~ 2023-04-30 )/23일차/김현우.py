import sys

sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ4196 - 도미노 (P4)

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


for _ in range(int(input())):
    n, m = map(int, input().split())
    graph = [[] for _ in range(n + 1)]
    reverse_graph = [[] for _ in range(n + 1)]
    for __ in range(m):
        a, b = map(int, input().split())
        graph[a].append(b)
        reverse_graph[b].append(a)

    stack = []
    result = []

    visited = [False for _ in range(n + 1)]
    for i in range(1, n + 1):
        if not visited[i]:
            dfs(i, visited, stack)

    indegree = 0
    indegrees = [-1 for _ in range(n + 1)]
    visited = [False for _ in range(n + 1)]
    while stack:
        ssc = []
        node = stack.pop()
        if not visited[node]:
            indegree += 1
            reverse_dfs(node, visited, ssc)
            result.append(sorted(ssc))

    scc_indegree = [0 for _ in range(indegree + 1)]
    for node in range(1, n + 1):
        for next_node in graph[node]:
            if indegrees[node] != indegrees[next_node]:
                scc_indegree[indegrees[next_node]] += 1

    count = 0
    for i in range(1, indegree + 1):
        if scc_indegree[i] == 0:
            count += 1

    print(count)