#include <stdio.h>

//프로그래머스 : 혼자 놀기의 달인

int getTrueCount(int list[], size_t cards_len){
    int result = 0;
    for(int i = 0 ; i < cards_len ; i ++){
        if(list[i] == 1) result++;
    }
    return result;
}

int solution(int cards[], size_t cards_len){
    int result = 0;
    
    int tf = 1;


    for(int i = 0 ; i < cards_len ; i++){
        int thisValue = 0;          //이번 시도 결과값
        int firstList [cards_len];
        for(int t = 0 ; t < cards_len ; t++)
            firstList[t] = 0;
        int firstListSize = 0;
        int nextP = cards[i] - 1;
        firstList[i] = 1;
        while(tf){
            if(firstList[nextP] == 1){
                //리스트 크기 측정
                firstListSize = getTrueCount(firstList, cards_len);
                break;
            }
            firstList[nextP] = 1;
            nextP = cards[nextP] - 1;
        }
       // printf("first pick card Count : %d", firstListSize);
        for(int x = 0 ; x < cards_len ; x++){
            int secondList [cards_len];
            for(int t = 0 ; t < cards_len ; t++)
                secondList[t] = 0;
            int secondListSize = 0;
            int startPoint = 0;
            if(firstList[x] == 1) continue;
            startPoint = x;
            firstList[x] = 1;
            secondList[x] = 1;
            startPoint = cards[x] - 1;
            while(tf){
                if(secondList[startPoint] == 1){
                    secondListSize = getTrueCount(secondList, cards_len);
                    int tValue = firstListSize * secondListSize;
                    //printf("this Try :: %d * %d = %d \n",firstListSize, secondListSize, tValue);
                    if(thisValue < tValue){
                        thisValue = tValue;
                    }
                    break;
                }
                secondList[startPoint] = 1;
                startPoint = cards[startPoint] - 1;
            }
            if(result < thisValue)
                result = thisValue;
        }
    }

    return result;
}