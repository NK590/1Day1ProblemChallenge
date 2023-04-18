/*
    Programmers Ä«µå ¹¶Ä¡ (159994)
*/

#include <iostream>

#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "";

    bool isAnswer = true;
    for (string str : goal) {
        bool existCards1 = false;
        bool existCards2 = false;

        if (cards1.size() > 0) {
            string card = cards1[0];
            if (card == str) {
                existCards1 = true;
                cards1.erase(cards1.begin(), cards1.begin() + 1);
            }
        }

        if (cards2.size() > 0) {
            string card = cards2[0];
            if (card == str) {
                existCards2 = true;
                cards2.erase(cards2.begin(), cards2.begin() + 1);
            }
        }

        if (!existCards1 && !existCards2) {
            isAnswer = false;
            break;
        }
    }

    if (isAnswer) answer = "Yes";
    else answer = "No";

    return answer;
}

int main() {
    vector<string> cards1 = { "i", "drink", "water" };
    vector<string> cards2 = { "want", "to" };
    vector<string> goal = { "i", "want", "to", "drink", "water"  };

    cout << solution(cards1, cards2, goal) << endl;
}
