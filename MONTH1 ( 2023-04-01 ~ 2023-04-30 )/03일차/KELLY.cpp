/**
추억 점수(176963)
죄송합니다.. 1단계에요..
*/

#include <iostream>

#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;

    // map 만들기
    map<string, int> yearningMap;
    for (int i = 0; i < name.size(); i++) {
        yearningMap.insert({ name[i] , yearning[i] });
    }

    for (vector<string> photo_vec : photo) {
        int yearning_total_num = 0;
        for (string photo_name : photo_vec) {
            if (yearningMap.find(photo_name) != yearningMap.end()) {
                map<string, int>::iterator iter = yearningMap.find(photo_name);
                yearning_total_num += iter->second;
            }
        }

        answer.push_back(yearning_total_num);
    }


    return answer;
}

void main() {
    vector<string> name = { "may", "kein", "kain", "radi" };
    vector<int> yearning = { 5, 10, 1, 3 };
    vector<vector<string>> photo = { {"may", "kein", "kain", "radi"} ,{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"} };
    vector<int> results = solution(name, yearning, photo);

    for (int result : results) {
        cout << result << endl;
    }
}