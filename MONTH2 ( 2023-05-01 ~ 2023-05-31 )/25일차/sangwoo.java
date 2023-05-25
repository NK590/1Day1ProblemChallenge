package examplenote;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 *
 * */
public class sangwoo {

    private static Set<Integer> list = new HashSet<Integer>();

    public static void main(String[] args) {

        String number = "00";
        System.out.println(solution(number));


    }

    public static int solution(String numbers){

        int result = 0;
        String[] arr = numbers.split("");
        String[] output = {};
        for(int i = 1; i<= arr.length; i++){
            boolean[] visited = new boolean[arr.length];
            output = new String[arr.length];
            per(arr,output,visited,0,arr.length,i);
        }
        boolean isNotPrime = false;
        for(Integer n : list){
            isNotPrime = false;
            System.out.println(n);
            for (int i = 2; i<=(int)Math.sqrt(n); i++) {
                if (n % i == 0 ) {
                    isNotPrime = true;
                    break;
                }
            }
            if(!isNotPrime && n != 1) {
                result++;
            }
        }
        return result;

    }
    public static void per(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < r; i++ ){
                str.append(output[i]);
            }
            int x = Integer.parseInt(str.toString());
            if(x != 0 && x != 1 ) {
                list.add(x);
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                per(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
