import sys

input = sys.stdin.readline

# BOJ18511 - 큰 수 구성하기 (S5)

def backtrack(num, digit):
    global ans
    if int(num) > n:
        return
    ans = max(ans, int(num))
    for next_num in li:
        backtrack(num + str(next_num), digit + 1)

n, k = map(int, input().split())
li = list(map(int, input().split()))

ans = 0
for num in li:
    backtrack(str(num), 1)

print(ans)