package examplenote;


/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/12977
 *
 *
 *소수 만들기
 * 문제 설명
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 * nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 * 입출력 예
 * nums	result
 * [1,2,3,4]	1
 * [1,2,7,6,4]	4
 * 입출력 예 설명
 * 입출력 예 #1
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 *
 * 입출력 예 #2
 * [1,2,4]를 이용해서 7을 만들 수 있습니다.
 * [1,4,6]을 이용해서 11을 만들 수 있습니다.
 * [2,4,7]을 이용해서 13을 만들 수 있습니다.
 * [4,6,7]을 이용해서 17을 만들 수 있습니다.
 *
 *
 *
 * */
public class Example12977 {

    public static void main(String[] args) {




        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){

        int n = nums.length;
        boolean[] visited = new boolean[n];
        int  cnt = 0;
        int result = comb(nums,visited,0,n , 3,cnt);


        return result;
    }



    public static int comb(int[] arr, boolean[] visited, int depth, int n, int r, int cnt) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }

            System.out.println(sum);
            for (int i = 2; i<=(int)Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    return cnt;
                }
            }
            cnt++;
            System.out.println("소수 ");
            return cnt;
        }

        if (depth == n) {
            return cnt;
        }

        visited[depth] = true;
        cnt = comb(arr, visited, depth + 1, n, r - 1,cnt);

        visited[depth] = false;
        cnt = comb(arr, visited, depth + 1, n, r,cnt);

        return cnt;
    }
}
