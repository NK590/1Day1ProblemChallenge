/*
    Programmers 실패율 (42889)
*/

#include <iostream>

#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

bool sort_prco(const pair<int, double>& a, const pair<int, double>& b);
vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> success_vec;
    map<int, double> stages_map;

    for (int i = 0; i < N; i++) {
        success_vec.push_back(0);
    }

    for (int i = 0; i < stages.size(); i++) {
        int last_stage = stages[i];

        for (int j = 0; j < last_stage - 1; j++) {
            // 스테이지별 성공한 사람 ++
            success_vec[j]++;
        }
    }

    int people_num = stages.size();
    for (int i = 0; i < success_vec.size(); i++) {
        // cout << (double)(people_num - success_vec[i]) / people_num << endl;
        // cout << (double)(people_num - success_vec[i]) << " " << people_num << endl;
        if(people_num - success_vec[i] <= 0) stages_map.insert({ i + 1, 0});
        else stages_map.insert({ i + 1, (double)((double)people_num - (double)success_vec[i]) / people_num });
        
        people_num -= people_num - success_vec[i];
    }

    vector<pair<int, double>> v(stages_map.begin(), stages_map.end());
    sort(v.begin(), v.end(), sort_prco);

    for (pair<int, double> n : v) {
        answer.push_back(n.first);
    }
    return answer;
}

bool sort_prco(const pair<int, double>& a, const pair<int, double>& b) {
    if (a.second == b.second) return a.first < b.first;
    return a.second > b.second;
}

int main() {
    int N = 5;
    vector<int> stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
    for (int result : solution(N, stages)) {
        cout << result << endl;
    }
}