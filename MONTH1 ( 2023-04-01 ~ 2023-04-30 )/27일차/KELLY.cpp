/*
    Programmers
    푸트 파이트 대회 (134240)

*/

#include <iostream>

#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    string left = "";
    string right = "";

    for (int i = 1; i < food.size(); i++) {
        int target = food[i];
        int num = (int)(target / 2);

        for (int j = 0; j < num; j++) {
            left += to_string(i);
            right = to_string(i) + right;
        }
    }

    answer = left + "0" + right;

    return answer;
}

int main() {
    vector<int> food = { 1, 3, 4, 6 };
    cout << solution(food) << endl;
}