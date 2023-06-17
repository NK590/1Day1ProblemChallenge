def solution(n):
    global count
    count = 0
    # 체스판 행별로 가능한 퀸의 위치를 백트래킹 탐색
    # visited : 해당 행에 퀸을 놓은 열 인덱스를 저장
    visited = [0 for _ in range(n)]

    def backtrack(row):
        global count

        # n번째 행까지 탐색 완료했을 때 -> 퀸을 전부 놓았으므로 count += 1
        if row == n:
            count += 1
            return

        # 해당 행의 각 열에 퀸 놓아보기
        for c in range(n):
            visited[row] = c
            # 퀸이 위 행들 중 세로선상 or 대각선상에 있을 때 -> 퀸 놓을 수 없으므로 break
            for r in range(row):
                if visited[r] == visited[row] or row - r == abs(visited[r] - visited[row]):
                    break
            # 그게 아니면 다음 행으로 재귀탐색
            else:
                backtrack(row + 1)

    backtrack(0)

    return count