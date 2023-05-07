#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int* solution(const char* maps[], size_t maps_len);
int searchInt(int x, int y, int width, int height, char* maps[]);
int compare (const void* first, const void* second);

int main(void){
    const char* maps[4] = {"X591X", "X1X5X", "X231X", "1XXX1"};

    solution(maps, 4);

    return 0;
}

// 프로그래머스 lv2 무인도 여행 
// 문제 설명
// 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다. 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.

// 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.

// 제한사항
// 3 ≤ maps의 길이 ≤ 100
// 3 ≤ maps[i]의 길이 ≤ 100
// maps[i]는 'X' 또는 1 과 9 사이의 자연수로 이루어진 문자열입니다.
// 지도는 직사각형 형태입니다.
// 입출력 예
// maps	result
// ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
// ["XXX","XXX","XXX"]	[-1]

int* solution(const char* maps[], size_t maps_len) {
    const int height = maps_len;
    const int width  = strlen(maps[0]);

    //변수 옮겨 담기
    char* map [maps_len];
    for(int i = 0 ; i < height ; i++){
        map[i] = (char*)malloc(sizeof(char) * width);
        strcpy(map[i], maps[i]);
    }
    //탐색 시작
    int tStack [height*width];
    memset(&tStack, 0, sizeof(tStack));
    int top = 0;
    for(int i = 0 ; i < height ; i++){
        for(int j = 0 ; j < width ; j++){
            if(map[i][j] != 'X'){
                tStack[top] = searchInt(j, i, width, height, map);
                top++;
            }
        }
    }
    //하나도 섬이 없으면 -1 리턴
    if(tStack[0] == 0){
        int* result = (int*)malloc(sizeof(int) * 1);
        result[0] = -1;
        return result;
    }
    //정렬 후 반환
    int* answer = (int*)malloc(sizeof(int) * top); //답안 리스트
    for(int i = 0 ; i < top ; i++)
        answer[i] = tStack[i];
    qsort(answer, top, sizeof(int), compare);
    return answer;
}

//사방 탐색 후 바다가 아니거나 이미 탐색한 곳이 아니면 해당 숫자값 획득
int searchInt(int x, int y, int width, int height, char* maps[]){
    if(maps[y][x] == 'X') return 0;
    char tSupl = maps[y][x];
    int result = atoi(&tSupl);
    maps[y][x] = 'X';
    if(x > 0) result += searchInt(x-1, y, width, height, maps);
    if(x < width-1) result += searchInt(x+1, y, width, height, maps);
    if(y > 0) result += searchInt(x, y-1, width, height, maps);
    if(y < height-1) result += searchInt(x, y+1, width, height, maps);
    return result;
}

//정렬기능
int compare (const void* first, const void* second){
    if (*(int*)first > *(int*)second) return 1;
    else if (*(int*)first < *(int*)second) return -1;
    else return 0;
}
