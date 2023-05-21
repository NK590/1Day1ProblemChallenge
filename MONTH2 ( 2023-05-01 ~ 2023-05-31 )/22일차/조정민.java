// 백준 1655 - 가운데를 말해요

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 중간값을 기준으로 작은 숫자와 큰 숫자의 집합으로 관리
        // 중간 값보다 작은 수를 부를 경우 중간 값은 지금의 중간값 다음으로 작은 수가 중간값이 되고
        // 중간 값보가 큰 수를 부를 다음으로 큰 수가 중간값이 된다.
        // 지금까지 부른 수의 개수가 짝수개면 두 값 중 작은 값을 출력해야 한다.

        //

        int n = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();
        int midle = 0;
        int midle2 = 0;

        for(int i = 0; i < n; i++) {
            int num = Integer.valueOf(br.readLine());

            if(i == 0) {
                midle = num;
                bw.append(midle + "\n");
            } else {
                if(i % 2 == 1) {
                    // 지금까지 부른 수의 개수가 짝수개
                    if(num < midle) {
                        lower.add(num);
                        midle2 = midle;
                        midle = lower.poll();
                    } else {
                        higher.add(num);
                        midle2 = higher.poll();
                    }

                    bw.append(midle + "\n");
                } else {
                    // 지금까지 부른 수의 개수가 홀수개
                    if(num < midle) {
                        lower.add(num);
                        higher.add(midle2);
                    } else if(num > midle2) {
                        higher.add(num);
                        lower.add(midle);
                        midle = midle2;
                    } else {
                        higher.add(midle2);
                        lower.add(midle);
                        midle = num;
                    }

                    bw.append(midle + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
