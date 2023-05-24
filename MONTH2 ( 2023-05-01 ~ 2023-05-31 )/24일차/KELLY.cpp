/*
    Programmers ī�� (42842)
*/

#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(int brown, int yellow) {
    /*
        1. brown�� yellow �� ���� ���� �˾Ƴ��� = out, in
        2. �� �������ϱ� = total
        3. total ��� ¦ ���ϱ� (1, 48), (2, 24) ... = total_divide_pair
        4. in ��� ¦ ���ϱ� = in_divide_pair
        5. total_divide_pair�� in_divide_pair �߿� ������ �ִ��� ã��
    */

    vector<int> answer;
    int out = 0; int in = 0;
    int total = 0;

    map<int, int> total_divide_map;
    map<int, int> in_divide_map;

    // 1. brown�� yellow �� ���� ���� �˾Ƴ��� = out, in �˾Ƴ�����
    // out = (brown > yellow ? brown : yellow);
    // in = (brown > yellow ? yellow : brown);
    out = brown;
    in = yellow;

    // 2. �� �������ϱ� = total
    total = out + in;

    // 3. total ��� ¦ ���ϱ� (1, 48), (2, 24) ... = total_divide_pair
    {
        int idx = 1;
        while (idx <= total) {
            if (total % idx == 0) {
                if (total_divide_map.find(total / idx) != total_divide_map.end()) {
                    break;
                }
                total_divide_map.insert({idx, total / idx});
            }
            idx++;
        }
    }

    // 4. in ��� ¦ ���ϱ� = in_divide_pair (�̶� ��� ���� + 2)
    {
        int idx = 1;
        while (idx <= in) {
            if (in % idx == 0) {
                if (in_divide_map.find((in / idx) + 2) != in_divide_map.end()) {
                    break;
                }
                in_divide_map.insert({ idx + 2, (in / idx) + 2 });
            }
            idx++;
        }
    }

    // 5. total_divide_pair�� in_divide_pair �߿� ������ �ִ��� ã��
    map<int, int> comp_map = (total_divide_map.size() < in_divide_map.size() ? total_divide_map : in_divide_map);
    map<int, int> tagt_map = (total_divide_map.size() < in_divide_map.size() ? in_divide_map : total_divide_map);
    for (pair<int, int> comp_pair : comp_map) {
        for (pair<int, int> tagt_pair : tagt_map) {
            if (comp_pair.first == tagt_pair.first && comp_pair.second == tagt_pair.second) {
                if (comp_pair.first > tagt_pair.second) {
                    answer.push_back(comp_pair.first);
                    answer.push_back(comp_pair.second);
                }
                else {
                    answer.push_back(comp_pair.second);
                    answer.push_back(comp_pair.first);
                }
                break;
            }
        }
    }


    return answer;
}

int main() {
    int brown = 12;
    int yellow = 18;
    
    for (int target : solution(brown, yellow)) {
        cout << target << endl;
    }
}