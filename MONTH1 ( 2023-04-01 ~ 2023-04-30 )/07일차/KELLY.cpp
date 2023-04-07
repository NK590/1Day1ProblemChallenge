/*
    Programmers JadenCase 문자열 만들기(12951)
    KELLY
*/

#include <iostream>

#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(string input, char delimiter);
string solution(string s) {
    s += " !"; // 마지막 공백이 들어갈수 있어서 

    string answer = "";
    vector<string> s_split = split(s, ' ');

    for (int i = 0; i < s_split.size() - 1; i++) {
        string str = s_split[i];

        for (int j = 0; j < str.length(); j++) {
            char ch = str[j];
            
            // 처음은 대문자
            if (j == 0) {
                if ((int)ch >= (int)'a' && (int)ch <= (int)'z') {
                    ch = (ch - ((int)'a' - (int)'A'));
                }
            }
            // 처음 제외 소문자
            else {
                if ((int)ch >= 'A' && (int)ch <= 'Z') {
                    ch = (ch + ((int)'a' - (int)'A'));
                }
            }
            str[j] = ch;
        }

        answer += str;
        if (i != s_split.size() - 2) {
            answer += " ";
        }
    }
    return answer;
}

vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;

    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }

    return answer;
}

int main() {
    string s = "3pe0ple  aFAllowed me  ";
    cout << solution(s) << endl;
}