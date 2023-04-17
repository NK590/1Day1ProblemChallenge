import sys
sys.setrecursionlimit(1000001)

input = sys.stdin.readline

# BOJ15681 - 트리와 쿼리 (G5)

def dfs(node):
    for next_node in graph[node]:
        if not visited[next_node]:
            visited[next_node] = True
            dfs(next_node)
            dp[node] += dp[next_node]

n, r, q = map(int, input().split())
graph = [[] for _ in range(n+1)]
dp = [1 for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited[r] = True
dfs(r)

for _ in range(q):
    print(dp[int(input())])