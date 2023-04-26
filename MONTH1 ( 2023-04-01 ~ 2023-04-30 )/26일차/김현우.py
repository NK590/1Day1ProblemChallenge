import sys

input = sys.stdin.readline

# BOJ1174 - 줄어드는 수 (G5)

def backtrack(num):
    ans.append(int(num))
    for i in range(int(num[-1])):
        backtrack(num + str(i))

n = int(input())
ans = []

try:
    for i in range(10):
        backtrack(str(i))
    ans.sort()
    print(ans[n-1])
except IndexError:
    print(-1)