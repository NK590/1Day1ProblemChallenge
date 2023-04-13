import sys

input = sys.stdin.readline

#BOJ1990 - 소수인팰린드롬(G5)

def is_prime(n):
    if n == 1 or n == 2 or n == 3:
        return True
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

palindrome = []
prime_palindrome = []

for i in range(1, 10000):
    palindrome.append(int(str(i) + str(i)[::-1][1:]))
    palindrome.append(int(str(i) + str(i)[::-1]))

palindrome.sort()

for num in palindrome:
    if is_prime(num):
        prime_palindrome.append(num)

a, b = map(int, input().split())
ans = [num for num in prime_palindrome if a <= num <= b]

if ans:
    print(*ans, sep='\n')
print(-1)