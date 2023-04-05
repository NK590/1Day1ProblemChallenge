/**
KELLY
Programmers ū �� �����(42883)
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

    // 1. ���ڸ� ���ڷ� ġȯ �� vector ���
    for (char ch : number) {
        number_vec.push_back(ch - '0');
    }

    // 2. answer�� �ʿ��� ���ڱ��̸�ŭ �ݺ�
    for (int i = 0; i < number.size() - k; i++) {
        // 3. ���� ���� ���� �ʿ��� ���ڱ���
        // ex) 6�� ���ڰ� �ʿ��ϸ� 5
        int need_num_size = number.size() - k - i;
        
        // 4. �ڿ������� [3.] ���� ��ŭ ¥����
        vector<int> number_vec_temp;
        number_vec_temp.assign(number_vec.begin(), number_vec.end() - need_num_size + 1);

        // 5. [4.] ���� ���� ū���� �ε��� ã��
        vector<int> max_num_loc = getMaxNumNIndex(number_vec_temp);

        // 6. ū�� answer �� ���ϱ�
        answer += to_string(max_num_loc[0]);

        // 7. �ε������� ~ 0��°���� ���ֱ�
        number_vec.erase(number_vec.begin(), number_vec.begin() + max_num_loc[1] + 1);
    }


    return answer;
}

vector<int> getMaxNumNIndex(vector<int> target) {
    vector<int> result = {0, 0};    // 0 : ū��, 1 : �ε���
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