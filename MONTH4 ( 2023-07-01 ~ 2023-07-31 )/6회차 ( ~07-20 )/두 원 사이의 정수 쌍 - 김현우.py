import math

def solution(r1, r2):
    answer = 0
    # 1사분면만 탐색하면서 점 개수 더하고 4 곱하기
    # x축 기준 1부터 r2까지 탐색하면서 큰 원 y값 - 작은 원 y값 사이에 있는 격자점 체크
    for i in range(1, r2 + 1) :
        upper_bound = math.floor((r2**2 - i**2)**0.5)
        lower_bound = math.ceil(max(0,r1**2 - i**2)**0.5)
        answer += upper_bound - lower_bound + 1
    return answer * 4