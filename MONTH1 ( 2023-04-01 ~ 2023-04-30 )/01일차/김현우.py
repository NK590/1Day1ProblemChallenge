import sys

input = sys.stdin.readline

# BOJ1708 - 볼록 껍질 (P5)

def ccw(p1, p2, p3):
    v1 = [p2[0] - p1[0], p2[1] - p1[1]]
    v2 = [p3[0] - p2[0], p3[1] - p2[1]]
    return v1[0] * v2[1] - v2[0] * v1[1]

n = int(input())
points = [list(map(int, input().split())) for _ in range(n)]
ans = 0

points.sort()

convex = []
for p3 in points:
    while len(convex) >= 2:
        p1, p2 = convex[-2], convex[-1]
        if ccw(p1, p2, p3) > 0:
            break
        convex.pop()
    convex.append(p3)
ans += len(convex)

convex = []
points.reverse()
for p3 in points:
    while len(convex) >= 2:
        p1, p2 = convex[-2], convex[-1]
        if ccw(p1, p2, p3) > 0:
            break
        convex.pop()
    convex.append(p3)
ans += len(convex)

print(ans - 2)
