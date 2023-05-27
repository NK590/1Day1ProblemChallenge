import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 - 연속합 https://www.acmicpc.net/problem/1912 - S2


public class Main {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberCount = Integer.parseInt(br.readLine());

        int array [][] = new int [numberCount][2];
        String sArray [] = br.readLine().split(" ");
        //누적합 계산
        for(int i = 0 ; i < array.length ; i++){
            array[i][0] = Integer.parseInt(sArray[i]);
            array[i][1] = getSumValue(array, i);
        }
        int maxSum = -10000;
        for(int i = 0 ; i < array.length ; i ++)
            if(maxSum < array[i][1]) maxSum = array[i][1];

        System.out.println(maxSum);
    }

    public static int getSumValue(int array [][], int index){
        int result = 0;
        if(index == 0 ){        //시작의 경우
            result = array[index][0];
        }else {
            int sum;
            if(array[index-1][1] < 0) sum = array[index][0];    //전에 단계가 초기화였다면 더하지 않음
            else sum = array[index-1][1] + array[index][0];
            
            if(sum < 0) result = array[index][0];               //합이 0보다 작으면 초기화
            else result = sum;
        }

        return result;
    }

}