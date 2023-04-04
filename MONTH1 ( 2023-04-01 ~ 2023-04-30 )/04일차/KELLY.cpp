/*
    Programmers 옹알이(1)(120956)
    친구가 풀어달래서... 1단계...
*/
#include <iostream>

#include <string>
#include <vector>
#include <regex>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;
    vector<string> posbl_babbling = { "aya", "ye", "woo", "ma" };
    
    for (string babbling_str : babbling) {
        for (string posbl_babbling_str : posbl_babbling) {
            babbling_str = regex_replace(babbling_str, regex(posbl_babbling_str), " ");
        }


        if (regex_replace(babbling_str, regex(" "), "") == "") {
            answer++;
        }
    }

    return answer;
}

int main() {
    vector<string> babbling = { "aya", "yee", "u", "maa", "wyeoo" };
    cout << solution(babbling) << endl;
}