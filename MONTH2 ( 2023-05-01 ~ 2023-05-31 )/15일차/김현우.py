import sys

input = sys.stdin.readline

# BOJ25945 - 컨테이너 재배치 (S3)

n = int(input())
li = list(map(int, input().split()))
li.sort()
sum_li = sum(li)
li2 = [sum_li // n for _ in range(n - sum_li % n)] + [(sum_li // n) + 1 for _ in range(sum_li % n)]
ans = 0

for i in range(n):
    if li[i] < li2[i]:
        ans += li2[i] - li[i]

print(ans)