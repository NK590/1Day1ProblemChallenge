from heapq import heapify, heappush, heappop

def solution(n, k, enemy):
    # 무적권을 사용할 타이밍을 우선순위 큐로 찾기
    enemy_list = enemy[:k]
    heapify(enemy_list)
    # 라운드 진행 도중 무적권 사용하고도 중간에 n이 0보다 작아지면 게임오버
    # -> 해당 라운드 출력
    for i in range(k, len(enemy)):
        heappush(enemy_list, enemy[i])
        n -= heappop(enemy_list)
        if n < 0:
            return i
    # 전 라운드 클리어시 전체 라운드 개수를 return
    return len(enemy)