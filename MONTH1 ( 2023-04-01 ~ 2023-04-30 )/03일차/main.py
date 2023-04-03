import sys
from math import log2, ceil

input = sys.stdin.readline

# BOJ14426 - 수열과 쿼리 16 (G1)

def min(a:list, b:list) -> list:
    if a[0] > b[0]:
        return b
    else:
        return a

def init(node, start, end):
    if start == end:
        tree[node] = a[start]
        return tree[node]
    else:
        tree[node] = min(init(node*2, start, (start+end)//2), init(node*2+1, (start+end)//2+1, end))
        return tree[node]

def query(node, start, end, left, right):
    if left > end or right < start:
        return [sys.maxsize, sys.maxsize]
    if left <= start and end <= right:
        return tree[node]
    return min(query(node*2, start, (start+end)//2, left, right), query(node*2+1, (start+end)//2+1, end, left, right))

def update(node, start, end, index, val):
    if index < start or index > end:
        return [sys.maxsize, sys.maxsize]
    if start == end:
        tree[node] = val
        return
    update(node*2, start, (start+end)//2, index, val)
    update(node*2+1, (start+end)//2+1, end, index, val)
    tree[node] = min(tree[node*2], tree[node*2+1])

n = int(input())
temp = list(map(int, input().split()))
a = [[0, 0] for _ in range(n)]

for i in range(n):
    a[i][0] = temp[i]
    a[i][1] = i + 1
tree = [0 for _ in range(1 << (ceil(log2(n))) + 1)]

init(1, 0, n-1)

m = int(input())
for _ in range(m):
    cmd, index, val = map(int, input().split())

    if cmd == 1:
        a[index-1][0] = val
        update(1, 0, n-1, index-1, a[index-1])
    else:
        print(query(1, 0, n-1, index-1, val-1)[1])
