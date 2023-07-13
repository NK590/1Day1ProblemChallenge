def solution(n):
    answer = []

    # 하노이의 탑 재귀 구현
    # n개를 3번째 기둥으로 이동 = n-1개를 먼저 2번째 기둥으로 이동 + 맨밑판을 3번째 기둥으로 이동 + 옮겨놨던 n-1개를 3번째 기둥으로 이동
    def hanoi(start, end, mid, n):
        if n == 1:
            answer.append([start, end])
        else:
            hanoi(start, mid, end, n - 1)
            hanoi(start, end, mid, 1)
            hanoi(mid, end, start, n - 1)

    hanoi(1, 3, 2, n)

    return answer