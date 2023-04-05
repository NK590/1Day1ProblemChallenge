/**
KELLY
Programmers 큰 수 만들기(42883)
*/

#include <iostream>

#include <string>
#include <vector>
#include <string>
#include <limits.h>

using namespace std;

vector<int> getMaxNumNIndex(vector<int> target);
string solution(string number, int k) {
    string answer = "";
    vector<int> number_vec = { };

    // 1. 문자를 숫자로 치환 후 vector 담기
    for (char ch : number) {
        number_vec.push_back(ch - '0');
    }

    // 2. answer에 필요한 숫자길이만큼 반복
    for (int i = 0; i < number.size() - k; i++) {
        // 3. 현재 숫자 제외 필요한 숫자길이
        // ex) 6개 숫자가 필요하면 5
        int need_num_size = number.size() - k - i;
        
        // 4. 뒤에서부터 [3.] 길이 만큼 짜르기
        vector<int> number_vec_temp;
        number_vec_temp.assign(number_vec.begin(), number_vec.end() - need_num_size + 1);

        // 5. [4.] 에서 제일 큰수와 인덱스 찾기
        vector<int> max_num_loc = getMaxNumNIndex(number_vec_temp);

        // 6. 큰수 answer 에 더하기
        answer += to_string(max_num_loc[0]);

        // 7. 인덱스포함 ~ 0번째까지 없애기
        number_vec.erase(number_vec.begin(), number_vec.begin() + max_num_loc[1] + 1);
    }


    return answer;
}

vector<int> getMaxNumNIndex(vector<int> target) {
    vector<int> result = {0, 0};    // 0 : 큰수, 1 : 인덱스
    int max_num = INT_MIN;
    int max_index = -1;

    for (int i = 0; i < target.size(); i++) {
        if (max_num < target[i]) {
            max_num = target[i];
            max_index = i;
        }
    }

    result[0] = max_num;
    result[1] = max_index;
    return result;
}

int main() {
    string number = "4177252841";
    int k = 4;
    cout << solution(number, k) << endl;
}