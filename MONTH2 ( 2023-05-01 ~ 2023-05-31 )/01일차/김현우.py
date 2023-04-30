import sys
sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ3648 - 아이돌 (P3)

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

while True:
    try:
        n, m = map(int, input().split())
        graph = [[] for _ in range(2*n + 1)]
        reverse_graph = [[] for _ in range(2*n + 1)]
        graph[0].append(1)
        graph[-1].append(0)
        reverse_graph[0].append(-1)
        reverse_graph[1].append(0)
        for __ in range(m):
            a, b = map(int, input().split())
            graph[-a].append(b)
            graph[-b].append(a)
            reverse_graph[b].append(-a)
            reverse_graph[a].append(-b)

        stack = []
        result = []

        visited = [False for _ in range(2*n + 1)]
        for i in range(1, 2*n + 1):
            if not visited[i]:
                dfs(i, visited, stack)

        indegree = 0
        indegrees = [-1 for _ in range(2*n + 1)]
        visited = [False for _ in range(2*n + 1)]
        while stack:
            scc = []
            node = stack.pop()
            if not visited[node]:
                indegree += 1
                reverse_dfs(node, visited, scc)
                result.append(sorted(scc))

        for i in range(1, n+1):
            if indegrees[i] == indegrees[-i]:
                print('no')
                break
        else:
            print('yes')

    except:
        break