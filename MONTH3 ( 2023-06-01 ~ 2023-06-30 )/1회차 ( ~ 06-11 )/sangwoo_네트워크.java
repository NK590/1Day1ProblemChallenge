package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 *
 * */
public class Example43162_ {

    public static void main(String[] args) {

        int n = 4;
        int[][] computers = {{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}};

        System.out.println(solution(n,computers));
    }

    public static int solution(int n , int[][] computers){

        int result = 0;

        boolean[] round = new boolean[n];

        for(int i = 0; i < computers.length; i++){

            if(round[i]){
                continue;
            }
            round[i] = true;
            tour2(computers, round,i,0);

            for(boolean x : round) System.out.print(x+",");
            System.out.println(" ++ 실행 "+   i);
            result++;

        }

        System.out.println("==================== ");
        return result;
    }


    public static void tour2(int[][] computers, boolean[] round, int i, int j){

        if(j >= computers.length || i >= computers.length) return;

        if(computers[i][j] == 1 && !round[j]){
            round[j]  = true;
            tour2(computers,round,j,0);
        }
        tour2(computers,round,i,j+1);

    }


}
