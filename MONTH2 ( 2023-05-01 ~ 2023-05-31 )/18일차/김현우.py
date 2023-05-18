import sys

input = sys.stdin.readline

# BOJ25487 - 단순한 문제 (Large) (S3)

for i in range(int(input())):
    a, b, c = map(int, input().split())
    print(min(a, b, c))