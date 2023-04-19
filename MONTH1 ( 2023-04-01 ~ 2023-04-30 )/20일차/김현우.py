import sys
sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ2150 - SCC (P5)

def dfs(node, visited, stack):
    visited[node] = True
    for ne in graph[node]:
        if not visited[ne]:
            dfs(ne, visited, stack)
    stack.append(node)

def reverse_dfs(node, visited, stack):
    visited[node] = True
    stack.append(node)
    for ne in reverse_graph[node]:
        if not visited[ne]:
            reverse_dfs(ne, visited, stack)

v, e = map(int, input().split())
graph = [[] for _ in range(v + 1)]
reverse_graph = [[] for _ in range(v + 1)]
for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    reverse_graph[b].append(a)

stack = []
result = []

visited = [False for _ in range(v + 1)]
for i in range(1, v + 1):
    if not visited[i]:
        dfs(i, visited, stack)
visited = [False for _ in range(v + 1)]
while stack:
    ssc = []
    node = stack.pop()
    if not visited[node]:
        reverse_dfs(node, visited, ssc)
        result.append(sorted(ssc))

print(len(result))
results = sorted(result)
for i in results:
    print(*i, -1)