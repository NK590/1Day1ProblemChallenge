import java.util.*;

class Solution {

    public int[][] solution(int n) {
        int[][] answer = {};
        List<int[]> list = new ArrayList<>();
        fn(n, 1, 3, list);
        return list.toArray(new int[list.size()][2]);
    }

    // n 을 f 에서 t 로 옮기기 위해서는
    // n - 1 개를 f 와 t 가 아닌 곳으로 옮겨야 한다.
    // 옮긴 후 f 와 t 가 아닌곳에 있는 탑을 t 로 가져와야 한다.

    public void fn(int n, int f, int t, List<int[]> list) {
        if(n == 1) {
            list.add(new int[] {f, t});
            System.out.println(f + " => " + t);
            return;
        }

        fn(n - 1, f, 6 - f - t, list);
        list.add(new int[] {f, t});
        System.out.println(f + " => " + t);
        fn(n - 1, 6 - f - t, t, list);
    }
}