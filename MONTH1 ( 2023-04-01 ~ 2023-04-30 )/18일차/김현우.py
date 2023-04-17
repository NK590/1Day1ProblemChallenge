import sys
sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ14267 - 회사 문화 1 (G4)

def dfs(node):
    for next_node in graph[node]:
        if not visited[next_node]:
            visited[next_node] = True
            dp[next_node] += dp[node]
            dfs(next_node)

n, m = map(int, input().split())
prev = list(map(int, input().split()))
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
dp = [0 for _ in range(n+1)]

for i in range(1, n):
    graph[i+1].append(prev[i])
    graph[prev[i]].append(i+1)

for _ in range(m):
    i, w = map(int, input().split())
    dp[i] += w

visited[1] = True
dfs(1)

print(*dp[1:])