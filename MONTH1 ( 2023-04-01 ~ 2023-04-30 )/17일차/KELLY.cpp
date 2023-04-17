/*
    Programmers ¼ýÀÚ Â¦±Ã(131128)
*/

#include <iostream>

#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    map<int, int> X_map;
    map<int, int> Y_map;
    
    for (char ch : X) {
        int ch_int = (int)ch - 48;

        if (X_map.find(ch_int) != X_map.end()) {
            X_map[ch_int]++;
        }
        else {
            X_map.insert({ch_int, 1});
        }
    }

    for (char ch : Y) {
        int ch_int = (int)ch - 48;

        if (Y_map.find(ch_int) != Y_map.end()) {
            Y_map[ch_int]++;
        }
        else {
            Y_map.insert({ ch_int, 1 });
        }
    }

    map<int, int> short_map;
    map<int, int> long_map;
    if (X_map.size() < Y_map.size()) {
        short_map = X_map;
        long_map = Y_map;
    }
    else {
        short_map = Y_map;
        long_map = X_map;
    }

    vector<int> dup_vec = {};
    for (auto iterator : short_map) {
        int key = iterator.first;
        int value = iterator.second;

        if (long_map.find(key) != long_map.end()) {
            int long_value = long_map[key];
            
            int repeat_num = 0;
            if (value < long_value) repeat_num = value;
            else repeat_num = long_value;

            for (int i = 0; i < repeat_num; i++) {
                dup_vec.push_back(key);
            }
        }
    }

    sort(dup_vec.rbegin(), dup_vec.rend());

    for (int target : dup_vec) {
        if (answer.length() == 0 && target == 0) {
            continue;
        }
        answer += to_string(target);
    }

    if (dup_vec.size() == 0) {
        answer = "-1";
    }
    else if(answer.length() == 0){
        answer = "0";
    }

    return answer;
}

int main() {
    string X = "5525";
    string Y = "1255";
    cout << solution(X, Y) << endl;
}