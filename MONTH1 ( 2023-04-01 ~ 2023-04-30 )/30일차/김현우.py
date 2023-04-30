import sys
sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ2207 - 가위바위보 (P4)

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

n, m = map(int, input().split())
graph = [[] for _ in range(2*n + 1)]
reverse_graph = [[] for _ in range(2*n + 1)]
for __ in range(n):
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
        print('OTL')
        break
else:
    print('^_^')