import sys
from math import *

input = sys.stdin.readline

n, m = map(int, input().split())

# 최대값을 처리할 세그먼트 트리, 최소값을 처리할 세그먼트 트리를 따로 선언
# 업데이트 쿼리 이 문제에서 필요없으므로, 세그먼트 트리 init과 구간쿼리만 정의
entry = [int(input()) for _ in range(n)]
tree_min = [0 for _ in range(1 << (int(ceil(log2(n))) + 1))]
tree_max = [0 for _ in range(1 << (int(ceil(log2(n))) + 1))]

def init_min(node, start, end):
    if start == end:
        tree_min[node] = entry[start]
    else:
        tree_min[node] = min(init_min(2 * node, start, (start + end) // 2),
                             init_min(2 * node + 1, (start + end) // 2 + 1, end))
    return tree_min[node]

def init_max(node, start, end):
    if start == end:
        tree_max[node] = entry[start]
    else:
        tree_max[node] = max(init_max(2 * node, start, (start + end) // 2),
                             init_max(2 * node + 1, (start + end) // 2 + 1, end))
    return tree_max[node]

def query_min(node, start, end, left, right):
    if left > end or right < start:
        return 1000000001

    if left <= start and end <= right:
        return tree_min[node]

    return min(query_min(2 * node, start, (start + end) // 2, left, right),
               query_min(2 * node + 1, (start + end) // 2 + 1, end, left, right))

def query_max(node, start, end, left, right):
    if left > end or right < start:
        return 0

    if left <= start and end <= right:
        return tree_max[node]

    return max(query_max(2 * node, start, (start + end) // 2, left, right),
               query_max(2 * node + 1, (start + end) // 2 + 1, end, left, right))

init_min(1, 0, n - 1)
init_max(1, 0, n - 1)

for _ in range(m):
    # 입력되는 구간 쿼리에 맞춰서 최소값, 최대값 결과 출력
    a, b = map(int, input().split())
    print(query_min(1, 0, n - 1, a - 1, b - 1), query_max(1, 0, n - 1, a - 1, b - 1), sep=' ')