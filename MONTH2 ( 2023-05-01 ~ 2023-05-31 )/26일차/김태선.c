#include <stdio.h>
#include <stdlib.h>

int getAscNum(int array [][3], int thisNum, int index);
int getDescNum(int array [][3], int thisNum, int index, int length);


//백준 https://www.acmicpc.net/problem/11054 - G4 가장 긴 바이토닉 부분 수열

int main(void){

    int N;
    scanf("%d", &N);

    int array [N][3];

    //오름차순 최대값 계산
    for(int i = 0 ; i < N ; i++){
        array[i][0] = 0;        //초기화
        array[i][1] = 0;        //초기화
        array[i][2] = 0;        //초기화
        scanf("%d", &array[i][0]);
        array[i][1] = getAscNum(array, array[i][0], i);
    }

    //내림차순 최대값 계산
    for(int i = N ; i > 0 ; i--){
        array[i-1][2] = getDescNum(array, array[i-1][0], i, N);
    }

    //최대 가능성 계산
    int anwser = 0;
    for(int i = 0 ; i < N ; i++){
        int tR = array[i][1] + array[i][2];
        if(anwser < tR) anwser = tR;
    }
    if(anwser > 1) --anwser;
    printf("%d", anwser);

    return 0;
}

//오름차순 값 얻기
int getAscNum(int array [][3], int thisNum, int index){
    if(index == 0) return 1;
    int result = 0;
    for(int i = index-1 ; i >= 0 ; i--){
        if(array[i][0] < thisNum && result < array[i][1] ) result = array[i][1];
    }
    result++;
    return result;
}
//내림차순 값 얻기
int getDescNum(int array [][3], int thisNum, int index, int length){
    if(index == length) return 1;
    int result = 0;
    for(int i = index-1 ; i < length ; i++){
        if(array[i][0] < thisNum && result < array[i][2] ) result = array[i][2];
    }
    result++;
    return result;
}