import sys

input = sys.stdin.readline

# BOJ2961 - 도영이가 만든 맛있는 음식 (S2)

n = int(input())
li = [list(map(int, input().split())) for _ in range(n)]

ans = sys.maxsize

for num in range(1, 1 << n):
    bitter = 0
    sour = 1
    for i in range(n):
        if num & (1 << i):
            sour *= li[i][0]
            bitter += li[i][1]
    ans = min(ans, abs(bitter - sour))

print(ans)