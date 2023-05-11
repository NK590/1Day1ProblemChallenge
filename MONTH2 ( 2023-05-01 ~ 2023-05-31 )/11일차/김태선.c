#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//프로그래머스 이진 변환 반복하기
int* solution(const char* s) {
    int* answer = (int*)malloc(sizeof(int) * 2);
    int deleteZero = 0;
    int calculationCount = 0;
    int size = 0;
    while (s[size] != '\0')  size++;
    
    char t [size];
    strcpy(t, s);
    while(1){
        int length = 0;
        int i = 0;
        while(t[i] != '\0'){
            if(t[i] == '0') deleteZero++;
            else length++;
            i++;
        }
        char tempChar [size];
        memset(tempChar, 0, size);
        int top = 0;
        while(length != 0){
            int yn = length & 1;
            char a = yn + '0';
            tempChar[top] = a;
            if(yn) length = (length - 1) / 2;
            else length = length / 2;
            top++;
        }
        i = 0;
        int tempSize = 0;
        while(tempChar[i] != '\0'){
            tempSize++;
            i++;
        } 
        char tempchar2 [size];

        calculationCount++;
        for(int e = 0 ; e <= tempSize ; e++)
            tempchar2[e] = tempChar[tempSize - e - 1];
        strcpy(t, tempchar2);
        if(tempSize == 1) break;
    }
    answer[0] = calculationCount;
    answer[1] = deleteZero;
    return answer;
}

int main(void){
    char* test1 = "01110";
    solution(test1);
    return 0;
}