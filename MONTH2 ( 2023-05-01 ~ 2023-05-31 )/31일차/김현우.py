import sys

input = sys.stdin.readline

# BOJ1951 - 활자 (S3)

n = input().rstrip()
ans = 0
for i in range(1, len(n)):
    ans += i * (9 * 10**(i-1))

ans += len(n) * (int(n) - 10**(len(n) - 1) + 1)

print(ans % 1234567)