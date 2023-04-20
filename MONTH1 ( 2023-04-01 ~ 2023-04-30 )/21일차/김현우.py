import sys
sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ1506 - 경찰서 (P5)

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

n = int(input())
price = list(map(int, input().split()))
grid = [list(map(int, list(input().rstrip()))) for _ in range(n)]
graph = [[] for _ in range(n)]
reverse_graph = [[] for _ in range(n)]

for i in range(n):
    for j in range(n):
        if grid[i][j] == 1:
            graph[i].append(j)
            reverse_graph[j].append(i)

stack = []
result = []

visited = [False for _ in range(n)]
for i in range(n):
    if not visited[i]:
        dfs(i, visited, stack)
visited = [False for _ in range(n)]
while stack:
    ssc = []
    node = stack.pop()
    if not visited[node]:
        reverse_dfs(node, visited, ssc)
        result.append(sorted(ssc))

ans = 0
for entry in result:
    ans += min([price[i] for i in entry])
print(ans)