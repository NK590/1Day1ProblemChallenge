/*
    Programmers 모의고사 (42840)
*/

#include <iostream>

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<vector<int>> people = {
        {1,2,3,4,5}
        , {2,1,2,3,2,4,2,5}
        , {3,3,1,1,2,2,4,4,5,5}
    };
    vector<int> people_idx = { 0, 0, 0 };
    vector<int> people_score = { 0, 0, 0 };

    for (int answer : answers) {
        for (int i = 0; i < people.size(); i++) {
            // 점수측정
            if (answer == people[i][people_idx[i]++]) {
                people_score[i]++;
            }

            // 인덱스 올리기
            if (people_idx[i] == people[i].size()) {
                people_idx[i] = 0;
            }
        }

    }
    
    vector<int> people_score_temp = people_score;
    sort(people_score_temp.rbegin(), people_score_temp.rend());

    int max_score = people_score_temp[0]; // 제일 큰 max
    for (int i = 0; i < people_score.size(); i++) {
        if (people_score[i] == max_score) {
            answer.push_back(i + 1);
        }
    }

    return answer;
}

int main() {
    vector<int> answers = { 1,3,2,4,2 };

    for (int result : solution(answers)) {
        cout << result << endl;
    }
}