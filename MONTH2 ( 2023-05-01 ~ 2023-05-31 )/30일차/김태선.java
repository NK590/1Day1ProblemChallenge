import java.io.BufferedReader;
import java.io.InputStreamReader;


//백준 - https://www.acmicpc.net/problem/1059 - S4

public class Main {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arrayLength = Integer.parseInt(br.readLine());

        int array [] = new int [arrayLength];

        String arrayS [] = br.readLine().split(" ");


        for(int i = 0 ; i < arrayLength ; i++){
            array[i] = Integer.parseInt(arrayS[i]);
        }

        int n = Integer.parseInt(br.readLine());

        int left = 0, right = 1000;
        for(int i = 0 ; i < arrayLength ; i++){
            if(n > array[i] && left < array[i]) left = array[i];
            if(n < array[i] && right > array[i]){
                right = array[i];
            }
            if(n == array[i]){
                System.out.println(0);
                return ;
            }
        }

        int lGap = n - left;
        int rGap = right - n;

        int result = lGap * rGap -1;        //경우의 수 계산식

        System.out.println(result);



    }

}