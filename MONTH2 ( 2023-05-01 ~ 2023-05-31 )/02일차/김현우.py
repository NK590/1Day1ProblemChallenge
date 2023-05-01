import sys
from collections import deque

input = sys.stdin.readline

# BOJ11003 - 최솟값 찾기 (P5)

n, l = map(int, input().split())
li = list(map(int, input().split()))
q = deque()
ans = []

for i in range(n):
    while q and q[-1][0] > li[i]:
        q.pop()
    while q and q[0][1] < i - l + 1:
        q.popleft()
    q.append((li[i], i))
    print(q[0][0], end = ' ')