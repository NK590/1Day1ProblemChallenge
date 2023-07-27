from math import sqrt

def solution(k, d):
    answer = 0

    # 우선 1사분면 원 안에 있는 점 카운트
    for i in range(0, d, k):
        x = sqrt(d ** 2 - i ** 2)
        answer += x // k

    # x축상 + 원점에 존재하는 점까지 카운트
    return answer + d // k + 1