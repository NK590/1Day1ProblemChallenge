import sys

# BOJ25333 - 개구리 (S5)

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

input = sys.stdin.readline

for _ in range(int(input())):
    a, b, x = map(int, input().split())
    print(x // gcd(a, b))