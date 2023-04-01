import sys

input = sys.stdin.readline

# BOJ23758 - 중앙값 제거 (S1)

n = int(input())
li = list(map(int, input().split()))
li.sort()
count = 0

for i in range((n+1)//2):
    while li[i] > 1:
        li[i] //= 2
        count += 1

print(count+1)
