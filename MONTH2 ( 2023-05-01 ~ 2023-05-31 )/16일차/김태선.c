#include <stdio.h>
#include <stdlib.h>
#define MAX(a, b) (((a) > (b)) ? (a) : (b))


//백준 - https://www.acmicpc.net/problem/1932 S1

int main(void){

    int maxvalue = 0;
    int lineSize;
    scanf("%d", &lineSize);

    int** list = (int**)malloc(sizeof(int*) * (lineSize+1));
    int** pocket = (int**)malloc(sizeof(int*) * (lineSize+1));
    for(int i = 0 ; i < lineSize ; i++){
        list[i] = (int*)malloc(sizeof(int) * (lineSize));
        pocket[i] = (int*)malloc(sizeof(int) * (lineSize));
        for(int j = 0 ; j <= i ; j++){
            scanf("%d", &list[i][j]);
            pocket[i][j] = 0;
        }
    }
    list[lineSize] = (int*)malloc(sizeof(int) * (lineSize+1));
    pocket[lineSize] = (int*)malloc(sizeof(int) * (lineSize+1));
    pocket[0][0] = list[0][0];

    for(int i = 1 ; i < lineSize ; i++){
        for(int j = 0 ; j <= i ; j++){
            if(j == 0){
                pocket[i][0] = list[i][0] + pocket[i-1][0];
            }else if(j == (i)){
                pocket[i][j] = list[i][j] + pocket[i-1][j-1];
            }else {
                pocket[i][j] = MAX(list[i][j] + pocket[i-1][j-1], list[i][j] + pocket[i-1][j]);
            }
        }
    }
    for(int i = 0 ; i < lineSize ; i++){
        for(int j = 0 ; j <= i ; j++){
            maxvalue = MAX(maxvalue, pocket[i][j]);
        }
    }
    
    printf("%d", maxvalue);
}
