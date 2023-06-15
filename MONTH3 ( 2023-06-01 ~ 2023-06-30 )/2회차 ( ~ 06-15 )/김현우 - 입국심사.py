import sys

def solution(n, times):
    # 심사를 받는 데 걸리는 총 시간 기준으로 탐색
    lo = 0
    hi = sys.maxsize
    mid = (lo + hi) // 2

    # 이분탐색 끝날때까지 루프
    while lo <= hi:
        # 이분탐색 현재 심사시간 (mid값) 일 때 심사할 수 있는 최대 인원수
        temp_count = sum(map(lambda x: mid // x, times))

        # 위에서 계산한 인원수가 n명보다 작을 때 -> 총 시간을 늘려서 이분탐색
        if temp_count < n:
            lo = mid + 1
            mid = (lo + hi) // 2
        # n명보다 작거나 같을 때 -> 총 시간을 줄여서 이분탐색
        else:
            hi = mid - 1
            mid = (lo + hi) // 2

    return lo