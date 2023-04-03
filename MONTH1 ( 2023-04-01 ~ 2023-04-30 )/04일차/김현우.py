import sys

input = sys.stdin.readline

# BOJ3896 - 소수 사이 수열 (S1)

is_prime = [True for _ in range(1300000)]
is_prime[1] = False

for i in range(2, int(1300000**0.5)+1):
    if is_prime[i]:
        for j in range(2*i, 1300000, i):
            is_prime[j] = False

for _ in range(int(input())):
    k = int(input())
    if is_prime[k]:
        print(0)
    else:
        lo = k
        hi = k
        while not is_prime[lo]:
            lo -= 1
        while not is_prime[hi]:
            hi += 1
        print(hi-lo)
