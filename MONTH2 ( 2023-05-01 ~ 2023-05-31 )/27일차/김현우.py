import sys

input = sys.stdin.readline

# BOJ1769 - 3의 배수 (S5)

n = input().rstrip()
count = 0

while len(n) > 1:
    n = str(sum(map(int, list(n))))
    count += 1

print(count)
print('YES' if int(n) % 3 == 0 else 'NO')