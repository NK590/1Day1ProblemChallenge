import sys

input = sys.stdin.readline

# BOJ23038 - 박스 그림 문자 (S4)

n, m = map(int, input().split())
grid = [list(input().rstrip()) for _ in range(3*n)]

for i in range(n):
    for j in range(m):
        for k in range(3):
            for l in range(3):
                x = 3*i + k
                y = 3*j + l
                if k == 1 and l == 1:
                    grid[x][y] = '#'
                if k == 0 and l == 1 and grid[x][y] == '#':
                    if i > 0:
                        grid[3*(i-1)+2][y] = '#'
                if k == 2 and l == 1 and grid[x][y] == '#':
                    if i < n-1:
                        grid[3*(i+1)][y] = '#'
                if k == 1 and l == 0 and grid[x][y] == '#':
                    if j > 0:
                        grid[x][3*(j-1)+2] = '#'
                if k == 1 and l == 2 and grid[x][y] == '#':
                    if j < m-1:
                        grid[x][3*(j+1)] = '#'

for i in range(3*n):
    print(''.join(grid[i]))