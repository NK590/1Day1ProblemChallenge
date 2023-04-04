public class sangwoo{


    private static int cnt = 0;

    public static void main(String[] args) {

        int[] number = {-2, 3, 0, 2, -5};
        solution(number);

    }

    public static int solution(int[] number){

        int answer = 0;

        int r = 3;
        int n = number.length;
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        comb(number,  visited, 0, number.length, r);

        return cnt;
    }

    private void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            int tmpSum = 0;
            for(int i =0; i < n; i++){
                if(visited[i]){
                    tmpSum += arr[i];
                }
            }
            if(tmpSum == 0) cnt++;
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

}