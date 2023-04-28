import sys

input = sys.stdin.readline

# BOJ2887 - 행성 터널 (P5)

def union(x, y):
    x = find(x)
    y = find(y)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

n = int(input())
li = []
for i in range(n):
    x, y, z = map(int, input().split())
    li.append((x, y, z, i))

edges = []
for i in range(3):
    li.sort(key=lambda x: x[i])
    for j in range(1, n):
        edges.append((abs(li[j-1][i] - li[j][i]), li[j-1][3], li[j][3]))

edges.sort()
parent = [i for i in range(n)]
ans = 0

for i in range(len(edges)):
    if find(edges[i][1]) != find(edges[i][2]):
        union(edges[i][1], edges[i][2])
        ans += edges[i][0]

print(ans)