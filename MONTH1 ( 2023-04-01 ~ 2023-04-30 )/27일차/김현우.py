import sys

input = sys.stdin.readline

# BOJ15824 - 너의 봄에는 캠사이신이 맛있단다 (G2)

def pow(i):
    if i == 0:
        return 1
    if i == 1:
        return 2
    temp = pow(i//2)
    if i % 2 == 0:
        return temp * temp % 1000000007
    else:
        return temp * temp * 2 % 1000000007

n = int(input())
li = list(map(int, input().split()))
li.sort()
ans = 0

for i in range(n):
    ans += li[i] * (pow(i) - pow(n-1-i))
    ans %= 1000000007

print(ans)