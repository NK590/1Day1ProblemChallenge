package examplenote;

/**
 *
 * url :https://school.programmers.co.kr/learn/courses/30/lessons/12950
 *
 *
 * */
public class sangwoo {

    public static void main(String[] args) {

        int[][] arr1 = {{1,2},{2,4},{1},{2}};
        int[][] arr2 = {{3,4},{5,6},{3},{4}};


        System.out.println(solution(arr1,arr2));


    }

    public static int[][] solution(int[][] arr1, int[][] arr2){
        int[][] result = new int[arr1.length][];
        for(int i =0; i < arr1.length;i++){
            result[i] = new int[arr1[i].length];
            for(int j = 0; j < arr1[i].length; j++){
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return result;
    }
}
