import sys

input = sys.stdin.readline

# BOJ9417 - 최대 GCD (S4)

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

for _ in range(int(input())):
    ans = 0
    li = list(map(int, input().split()))
    for i in range(len(li)-1):
        for j in range(i+1, len(li)):
            ans = max(ans, gcd(li[i], li[j]))
    print(ans)