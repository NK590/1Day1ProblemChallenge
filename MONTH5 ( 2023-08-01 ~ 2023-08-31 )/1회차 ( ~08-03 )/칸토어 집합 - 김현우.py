import sys

input = sys.stdin.readline

# 칸토어집합 재귀구현
def cantour(n):
    if n == 0:
        return '-'
    return cantour(n-1) + ' '*(3**(n-1)) + cantour(n-1)

# EOF 처리를 위한 입출력
while True:
    try:
        n = int(input())
        print(cantour(n))
    except:
        break