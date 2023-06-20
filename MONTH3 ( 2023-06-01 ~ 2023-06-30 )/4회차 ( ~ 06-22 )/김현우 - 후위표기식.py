import sys

input = sys.stdin.readline

# 짜다보니 무한 if-else로 코드가 상당히 더러워졌네요
# 기본 아이디어는 문제에도 적혀있지만, 연산자 나오면 일단 스택에 넣고 순차적으로 빼기

w = input().rstrip()

# 알파벳 리스트
a = [chr(x) for x in range(65, 65 + 26)]
# 문제풀이에 쓸 스택
s = []

for i in range(len(w)):
    # 알파벳일 때 -> 스택에 안 넣고 그냥 출력
    if w[i] in a:
        print(w[i], end='')
    # 괄호 열릴 때 -> 스택에 일단 넣기
    elif w[i] == '(':
        s.append(w[i])
    # 연산자가 나왔을 때
    elif w[i] in ['*', '/', '+', '-']:
        # 스택이 비었거나, 괄호가 열렸거나, 우선순위가 높은 연산자가 나왔을 때 -> 스택에 삽입
        while True:
            if s == []:
                s.append(w[i])
                break
            elif s[-1] == '(':
                s.append(w[i])
                break
            elif (w[i] in ['*', '/']) and (s[-1] in ['+', '-']):
                s.append(w[i])
                break
            # 그 외의 경우는 pop
            else:
                print(s.pop(), end='')
    # 괄호 닫힐 때 -> pop
    elif w[i] == ')':
        # 괄호 pair가 나올 때까지 pop
        while s[-1] != '(':
            print(s.pop(), end='')
        s.pop()

# 스택 남아있는 변수 처리
while s != []:
    print(s.pop(), end='')