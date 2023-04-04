import sys
sys.setrecursionlimit(100001)

input = sys.stdin.readline

# BOJ11266 - 단절점 (P4)

def dfs(curr, is_root):
    global node_count, indegree

    node_count += 1
    indegree[curr] = node_count

    cur_indegree = indegree[curr]
    child = 0

    for next in graph[curr]:
        if indegree[next] == 0:
            child += 1
            min_disc = dfs(next, False)
            if not is_root and min_disc >= indegree[curr]:
                cut.append(curr)
            cur_indegree = min(cur_indegree, min_disc)
        else:
            cur_indegree = min(cur_indegree, indegree[next])

    if is_root and child > 1:
        cut.append(curr)

    return cur_indegree

v, e = map(int, input().split())
graph = [[] for _ in range(v+1)]
indegree = [0 for _ in range(v+1)]
cut = []
node_count = 0

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, v+1):
    if indegree[i] == 0:
        dfs(i, True)

cut = list(set(cut))
cut.sort()

print(len(cut))
print(*cut)