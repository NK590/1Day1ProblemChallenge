#include <stdio.h>

int getMaxNum(int array [][2], int thisNum, int index);

// 백준 - https://www.acmicpc.net/problem/11053 - S2

int main(void){

    int numberCount;
    scanf("%d", &numberCount);

    int array [numberCount][2];

    for(int i = 0 ; i < numberCount ; i++){
        array[i][0] = 0;        //초기화
        array[i][1] = 0;        //초기화
        scanf("%d", &array[i][0]);
        array[i][1] = getMaxNum(array, array[i][0], i);
    }

    int anwser = 0;
    for(int i = 0 ; i < numberCount ; i++)
        if(anwser < array[i][1]) anwser = array[i][1];

    printf("%d", anwser);

    return 0;
}

int getMaxNum(int array [][2], int thisNum, int index){
    if(index == 0) return 1;
    int result = 0;
    for(int i = index-1 ; i >= 0 ; i--){
        if(array[i][0] < thisNum && result < array[i][1] ) result = array[i][1];
    }
    result++;
    return result;
}

