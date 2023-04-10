import java.util.*;


/**
 *
 *  url : https://school.programmers.co.kr/learn/courses/30/lessons/68644
 *
 * 문제 설명
 * 정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers의 길이는 2 이상 100 이하입니다.
 * numbers의 모든 수는 0 이상 100 이하입니다.
 * 입출력 예
 * numbers	result
 * [2,1,3,4,1]	[2,3,4,5,6,7]
 * [5,0,2,7]	[2,5,7,9,12]
 *
 * */

public class sangwoo{

    static List<Integer> sumList = new ArrayList<>();

    static Set<Integer> sumSet = new HashSet<Integer>();

    public static void main(String[] args) {

        int[] number = {2,1,3,4,1};

        solutino(number);
    }

    public static int[] solutino(int[] numbers){


        int r = 2;

        boolean[] visited = new boolean[numbers.length];
        comb(numbers,visited, 0, r);


        List<Integer> resultList = new ArrayList<Integer>(sumSet);
        Collections.sort(resultList);
        int[] result = new int[resultList.size()];

        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }

        return result;

    }

    static void comb(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            int sum = 0;
            for(int i =0; i < arr.length;i++){
                if(visited[i]){
                    sum += arr[i];
                }
            }
            sumSet.add(sum);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb(arr, visited, depth + 1, r);
        }
    }



}