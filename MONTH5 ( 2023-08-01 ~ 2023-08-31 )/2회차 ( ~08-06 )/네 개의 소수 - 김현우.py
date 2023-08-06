import sys

input = sys.stdin.readline

# 우선 에라토스테네스의 체로 소수리스트 뽑기
# 골드바흐의 추측을 통해, n이 짝수일 때와 홀수일 때로 나눠서 계산
# 1. n이 8 미만일 경우 소수 4개로 표현 불가능
# 2. n이 짝수일 경우, 2 + 2 + n-4로 생각하여 n-4를 두 소수로 표현
# 3. n이 홀수일 경우, 2 + 3 + n-5로 생각하여 n-5를 두 소수로 표현

def sieve():
    for i in range(2, n+1):
        if is_prime[i]:
            primes.append(i)
            for j in range(i**2, n+1, i):
                is_prime[j] = False
    pass

def goldbach(num):
    for i in range(len(primes)):
        for j in range(len(primes)):
            sum_num = primes[i] + primes[j]
            if sum_num == num:
                ans.extend([primes[i], primes[j]])
                return
            elif sum_num > num:
                break

n = int(input())
is_prime = [True for _ in range(n+1)]
is_prime[0] = is_prime[1] = False
primes = []

sieve()

if n < 8:
    print(-1)
elif n % 2 == 0:
    ans = [2, 2]
    n -= 4
    goldbach(n)
    print(*ans)
else:
    ans = [2, 3]
    n -= 5
    goldbach(n)
    print(*ans)