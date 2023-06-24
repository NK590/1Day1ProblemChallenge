import java.util.*;

class Solution {
    public int solution(String name) {
        // 상하
        // A-Z 총 26개로 최대 13번의 조작으로 모든 알파벳을 선택 가능

        // 좌우
        // 입력할 알파벳이 A 인 칸과 맨 첫 칸으로는 이동할 필요가 없기 때문에 해당하지 않는 칸의 위치만 리스트에 저장
        // 방문하는 순서는 크게 3가지 경우
        // 1. 계속 오른쪽으로 이동
        // 2. 계속 왼쪽으로 이동
        // 3. 오른쪽 또는 왼쪽으로 갔다고 반대쪽으로 가는 경우
        // 방문할 칸이 4개인 경우 1 2 3 4 
        // 1-2-3-4
        // 1 2-3-4-
        // 1-2 3-4-
        // 1-2-3 4-


        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if(c == 'A')
                continue;

            if(i != 0)
                list.add(i);

            int gap = (int) c - 'A';

            if(gap > 13) {
                answer += 26 - gap;
            } else {
                answer += gap;
            }

        }

        if(list.size() == 0)
            return answer;

        Collections.sort(list);

        int dist = list.get(list.size() - 1);
        dist = Math.min(dist, name.length() - list.get(0));

        for(int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);

            // b => 0
            // 0 => a            
            int bToZero = name.length() - b;
            int zeroToB = a;

            int cost = Math.min(bToZero, zeroToB) + bToZero + zeroToB;

            dist = Math.min(dist, cost);
        }

        answer += dist;

        return answer;
    }
}