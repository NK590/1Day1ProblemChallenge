import sys
sys.setrecursionlimit(1000001)

input = sys.stdin.readline

# BOJ2533 - 사회망 서비스 (G3)

def dfs(node):
    for next_node in graph[node]:
        if not visited[next_node]:
            visited[next_node] = True
            dfs(next_node)
            dp[node][0] += dp[next_node][1]
            dp[node][1] += min(dp[next_node])

n = int(input())
graph = [[] for _ in range(n+1)]
dp = [[0, 1] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited[1] = True
dfs(1)

print(min(dp[1]))