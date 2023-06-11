public class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int index, boolean[] visited, int[][] computers) {
        visited[index] = true;
        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[index][j] == 1) {
                dfs(j, visited, computers);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int t = 3;
        int[][] test = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.solution(t, test));
    }
}
