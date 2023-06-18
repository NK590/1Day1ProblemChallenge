package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/12952
 *
 * */
public class Example12952_ {

    private static int[] board = {};
    private static int count = 0;
    public static void main(String[] args) {

        int n = 4;
        System.out.println(solution(n));
    }

    public static int solution(int n){

        board = new int[n];

        nQueen(n,0);

        return count;

    }

    public static void nQueen(int n,int k){
        if(k == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            board[k] = i;
            if(backTracking(k) == 1){
                nQueen(n,k+1);
            }
        }

    }
    public static int backTracking(int k){

        for(int i = 0; i <k; i++ ){
            if(board[k] == board[i] || k -i == Math.abs(board[k]  - board[i])){
                return 0;
            }
        }
        return 1;
    }
}
