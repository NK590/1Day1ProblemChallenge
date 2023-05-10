#include <stdio.h>
#include <stdlib.h>

//다리 놓기 S5
//https://www.acmicpc.net/problem/1010

int main(void){
    int testCount;
    scanf("%d", &testCount);

    int bridge [testCount][2];
    for(int i = 0 ; i < testCount ; i++){
        scanf("%d %d", &bridge[i][0], &bridge[i][1]);
    }
    for(int i = 0 ; i < testCount ; i++){
        int n = bridge[i][0];
        int m = bridge[i][1];
        long long result = 1;
        int t = n;
        for(int j = 1 ; j <= n ; j++){
            result = result * m / j;
            m--;
        }
        printf("%lld\n", result);
    }
    return 0;
}