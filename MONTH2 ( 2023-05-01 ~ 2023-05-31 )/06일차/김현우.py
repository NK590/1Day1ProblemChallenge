import sys

# BOJ5615 - 아파트 임대 (P1)

def powmod(a, b, m):
    result = 1
    while b > 0:
        if b % 2 != 0:
            result = (result * a) % m
        b //= 2
        a = (a * a) % m

    return result

def MR(n, a):
    s = n - 1
    d = 0
    while s % 2 == 0:
        d += 1
        s = s // 2
    x = pow(a, s, n)

    if x == 1 or x == n - 1:
        return True
    for _ in range(0, d - 1):
        x = pow(x, 2, n)
        if x == n - 1:
            return True
    return False

ans = 0

for _ in range(int(sys.stdin.readline())):
    n = int(sys.stdin.readline())
    chk = 0

    for i in [2, 3, 5, 7, 11, 13, 17]:
        if MR(2*n+1, i) or n == 3:
            chk += 1
        else:
            break

    if chk == 7:
        ans += 1

print(ans)