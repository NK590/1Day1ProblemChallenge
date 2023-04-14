import sys

sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

# BOJ11400 - 단절선 (P4)

def DFS(curr: int, parent: int) -> int:
    global nodecnt, discover
    nodecnt += 1

    discover[curr] = nodecnt
    ret = discover[curr]

    for next in adjlist[curr]:
        if next == parent:
            continue
        if discover[next] == 0:
            mindisc = DFS(next, curr)

            if mindisc > discover[curr]:
                res.append([min(curr, next), max(curr, next)])
            ret = min(ret, mindisc)
        else:
            ret = min(ret, discover[next])

    return ret

V, E = map(int, input().split())

adjlist = [[] for _ in range(V + 1)]
discover = [0 for _ in range(V + 1)]
res = []
nodecnt = 0

for _ in range(E):
    A, B = map(int, input().split())
    adjlist[A].append(B)
    adjlist[B].append(A)

for v in range(1, V + 1):
    if discover[v] == 0:
        DFS(v, 1)

res.sort()
print(len(res))

for x, y in res:
    print(x, y)