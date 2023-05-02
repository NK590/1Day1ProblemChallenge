/*
    Programmers ÃÖ´ñ°ª°ú ÃÖ¼Ú°ª (12939)
*/

#include <iostream>

#include <string>
#include <vector>
#include <sstream>
#include <limits.h>
#include <string>

using namespace std;

vector<string> split(string input, char delimiter);
int getMax(vector<string> vec);
int getMin(vector<string> vec);
string solution(string s) {
    string answer = "";

    vector<string> s_split = split(s, ' ');
    int max = getMax(s_split);
    int min = getMin(s_split);
    
    answer = to_string(min) + " " + to_string(max);
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

int getMax(vector<string> vec) {
    int result = INT_MIN;
    for (string s : vec) {
        int s_int = stoi(s);
        if (result < s_int) result = s_int;
    }
    return result;
}

int getMin(vector<string> vec) {
    int result = INT_MAX;
    for (string s : vec) {
        int s_int = stoi(s);
        if (result > s_int) result = s_int;
    }
    return result;
}
int main() {
    string s = "1 2 3 4";
    cout << solution(s) << endl;
}