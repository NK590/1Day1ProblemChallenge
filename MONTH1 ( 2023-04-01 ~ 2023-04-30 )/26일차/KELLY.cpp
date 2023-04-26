/*
    Programmers 햄버거 만들기 (133502)
*/

#include <iostream>

#include <string>
#include <vector>
#include <regex>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    string ingredient_str = "";

    for (int ingred : ingredient) {
        ingredient_str += to_string(ingred);
    }
    int ingredient_idx = 0;
    while (true) {
        /*if (ingredient_idx == 0) ingredient_idx = 1;
        ingredient_idx = ingredient_str.find("1231", ingredient_idx - 1);
        if (ingredient_idx == string::npos) {
            break;
        }*/


        int find_idx = ingredient_idx - 2;
        if (find_idx < 0) find_idx = 0;
        ingredient_idx = ingredient_str.find("1231", find_idx);

        if (ingredient_idx == string::npos) {
            break;
        }

        ingredient_str.erase(ingredient_idx, 4);
        // ingredient_str.erase(ingredient_str.begin() + ingredient_idx, ingredient_str.begin() + ingredient_idx + 4);
        //ingredient_str.replace(ingredient_idx, 4, "");
        // ingredient_str = ingredient_str.substr(0, ingredient_idx) + ingredient_str.substr(ingredient_idx + 4);
        // cout << ingredient_str << endl;
        answer++;
    }

    return answer;
}

int main() {
    vector<int> ingredient = { 2, 1, 1, 2, 3, 1, 2, 3, 1 };
    cout << solution(ingredient) << endl;
}