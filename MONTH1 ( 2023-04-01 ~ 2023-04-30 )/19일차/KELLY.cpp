/*
    Programmers K¹øÂ°¼ö (42748)
*/

#include <iostream>

#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;

    for (vector<int> command : commands) {
        int i = command[0];
        int j = command[1];
        int k = command[2];

        vector<int> temp(array.begin() + i - 1, array.begin() + j);
        sort(temp.begin(), temp.end());

        answer.push_back(temp[k - 1]);
    }

    return answer;
}

int main() {
    vector<int> array = { 1, 5, 2, 6, 3, 7, 4 };
    vector<vector<int>> commands = { {2, 5, 3} ,{4, 4, 1},{1, 7, 3} };

    for (int result : solution(array, commands)) {
        cout << result << endl;
    }
}