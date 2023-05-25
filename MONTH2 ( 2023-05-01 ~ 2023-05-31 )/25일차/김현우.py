import sys

input = sys.stdin.readline

# BOJ8611 - 팰린드롬 숫자 (S5)

def is_palindrome(s):
    for i in range(len(s) // 2 + 1):
        if s[i] != s[-i - 1]:
            return False
    return True


n = int(input())
ans = []
for i in range(2, 11):
    temp_n = n
    temp_li = []
    while temp_n:
        temp_li.append(str(temp_n % i))
        temp_n = temp_n // i
    s = ''.join(temp_li[::-1])

    if is_palindrome(s):
        ans.append((i, int(s)))

if ans:
    for i in range(len(ans)):
        print(*ans[i])
else:
    print('NIE')