import sys

input = sys.stdin.readline

# BOJ12785 - 토쟁이의 등굣길 (S1)

def radix(a, b):
    ans = []
    while a:
        ans.append(a % b)
        a = a // b
    return ans[::-1]


def bin(n, k, p):
    if n < k:
        return 0
    else:
        li = [0 for _ in range(n + 1)]
        li[0] = 1
        for i in range(1, n + 1):
            li[i] = li[i - 1] * i

        return (li[n]) // ((li[k]) * (li[n - k])) % p


mod = 1000007
w, h = map(int, input().split())
x, y = map(int, input().split())

n1, k1 = (x + y - 2), x - 1
n2, k2 = (w + h - x - y), w - x
ans1 = 1
ans2 = 1

n1_radix = radix(n1, mod)
k1_radix = radix(k1, mod)
n2_radix = radix(n2, mod)
k2_radix = radix(k2, mod)

if len(n1_radix) != len(k1_radix):
    k1_radix = [0] * (len(n1_radix) - len(k1_radix)) + k1_radix

for i in range(len(n1_radix)):
    ans1 = ans1 * bin(n1_radix[i], k1_radix[i], mod) % mod

if len(n2_radix) != len(k2_radix):
    k2_radix = [0] * (len(n2_radix) - len(k2_radix)) + k2_radix

for i in range(len(n2_radix)):
    ans2 = ans2 * bin(n2_radix[i], k2_radix[i], mod) % mod

print((ans1 * ans2) % mod)