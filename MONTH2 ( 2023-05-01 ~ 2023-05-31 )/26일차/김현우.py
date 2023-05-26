import sys

input = sys.stdin.readline

# BOJ14627 - 파닭파닭

s, c = map(int, input().split())
li = [int(input()) for _ in range(s)]

lo = 1
hi = sys.maxsize
mid = (lo + hi) // 2
while lo <= hi:
    count = sum(map(lambda x : x // mid, li))
    if count < c:
        hi = mid - 1
        mid = (lo + hi) // 2
    else:
        lo = mid + 1
        mid = (lo + hi) // 2

if sum(map(lambda x : x // hi, li)) == c:
    print(sum(map(lambda x : x % hi, li)))
else:
    ans = 0
    count_temp = 0
    for i in range(s):
        if c <= count_temp + li[i] // hi:
            ans += li[i] - hi * ((count_temp + li[i] // hi) - c)
            count_temp += (count_temp + li[i] // hi) - c
        else:
            ans += li[i] % hi
            count_temp += li[i] // hi
    print(ans)