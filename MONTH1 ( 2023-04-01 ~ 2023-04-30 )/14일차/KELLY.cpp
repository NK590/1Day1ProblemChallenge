/*
    Programmers 바탕화면 정리 (161990)
*/

#include <iostream>

#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer = {60, 60, -1, -1};

    for (int i = 0; i < wallpaper.size(); i++) {
        string str = wallpaper[i];

        for (int j = 0; j < str.length(); j++) {
            char ch = str[j];

            if ('#' == ch) {
                // 보자보자..

                if (i < answer[0]) answer[0] = i;
                if (j < answer[1]) answer[1] = j;
                if (i > answer[2]) answer[2] = i;
                if (j > answer[3]) answer[3] = j;
            }
        }
    }
    
    answer[2]++;
    answer[3]++;
    return answer;
}

int main() {
    vector<string> wallpaper = { "..", "#." };
    for (int result : solution(wallpaper)) {
        cout << result << endl;
    }
}