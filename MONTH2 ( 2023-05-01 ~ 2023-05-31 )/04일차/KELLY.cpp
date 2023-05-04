/*
    Programmers 두 개 뽑아서 더하기 (68644)
*/

#include <iostream>

#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    map<int, int> answer_map;
    for (int i = 0; i < numbers.size(); i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            int number1 = numbers[i];
            int number2 = numbers[j];

            if (answer_map.find(number1 + number2) == answer_map.end()) {
                answer_map.insert({number1 + number2, 0});
            }
        }
    }

    for (auto map : answer_map) {
        int value = map.first;
        answer.push_back(value);
    }
    return answer;
}

int main() {
    vector<int> numbers = { 2,1,3,4,1 };
    for (int result : solution(numbers)) {
        cout << result << endl;
    }
}