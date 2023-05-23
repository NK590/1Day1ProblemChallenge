/*
    Programmers 짝지어 제거하기 (12973)
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

int solution(string s)
{
    int answer = -1;
    char pre_ch = '!'; // 처음이란 뜻
    vector<char> s_vec = {};

    //vector<char>::iterator iter = s_vec.begin();
    //while (iter != s_vec.end()) {
    //    char ch = *iter;

    //    if (pre_ch == '!') {
    //        pre_ch = ch;
    //        iter++;
    //        continue;
    //    }
    //    else {
    //        // 연속
    //        if (pre_ch == ch) {
    //            iter = s_vec.erase(iter - 1, iter + 1);
    //            if (iter != s_vec.begin()) iter--;
    //            pre_ch = '!';
    //        }
    //        else {
    //            iter++;
    //            pre_ch = ch;
    //            continue;
    //        }
    //    }
    //}


    //int idx = 0;
    //while (idx != s_vec.size()) {
    //    char ch = s_vec[idx];

    //    if (pre_ch == '!') {
    //        pre_ch = ch;
    //        idx++;
    //        continue;
    //    }
    //    else {
    //        // 연속
    //        if (pre_ch == ch) {
    //            s_vec.erase(s_vec.begin() + idx - 1, s_vec.begin() + idx + 1);
    //            if (idx > 1) idx = idx - 2;
    //            else idx = 0;
    //            pre_ch = '!';
    //        }
    //        else {
    //            idx++;
    //            pre_ch = ch;
    //            continue;
    //        }
    //    }
    //}


    for (char ch : s) {
        if (s_vec.size() > 0) {
            if (s_vec[s_vec.size() - 1] == ch) {
                s_vec.pop_back();
                continue;
            }
        }
        s_vec.push_back(ch);
    }

    if (s_vec.size() != 0) return 0;
    else if (s_vec.size() == 0) return 1;

    return answer;
}

int main() {
    string s = "baabaa";
    // cout << s.substr(0, 0) + s.substr(1) << endl;
    cout << solution(s) << endl;
}