#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

void solution();
int fnCalculation(int param, int* array);

int main(void){
    clock_t start = clock();
 
    solution();

    clock_t end = clock();
    printf("time: %lf\n", (double)(end - start) / CLOCKS_PER_SEC); 
    return 0;
}


void solution(){
    //배열 초기화
    int result [10000] = {0};
    for(int i = 0 ; i < 10000 ; i++) result[i] = i+1;

    //포인터 설정
    int* array = &result[0];

    //셀프넘버 구하기
    for(int i = 0 ; i < 10000 ; i++) fnCalculation(i+1, array);

    //출력하기
    for(int i = 0 ; i < 10000 ; i++) if(result[i] != -1) printf("%d\n", result[i]);

}

// 79 -> 79 + 7 + 9 = 95 로 계산 후 배열에서 해당 부분은 -1로 처리
int fnCalculation(int param, int* array){
    if(param > 10000) return 0;
    int result = param;
    
    while(1){
        if(!param) break;
        result += param % 10;
        param = param - (param % 10);
        param = param / 10;
    }
    if(result <= 10000) array[result-1] = -1;
    return fnCalculation(result, array);
}