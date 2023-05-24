import sys

input = sys.stdin.readline

# BOJ1251 - 단어 나누기 (S5)

s = input().rstrip()
li = []

for i in range(1, len(s)-1):
    for j in range(i+1, len(s)):
        s1 = s[:i]
        s2 = s[i:j]
        s3 = s[j:]
        li.append(s1[::-1] + s2[::-1] + s3[::-1])

li.sort()

print(li[0])