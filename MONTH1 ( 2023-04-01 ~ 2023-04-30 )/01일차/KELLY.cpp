/**
 * @file P_176962.cpp
 * @author Kelly (rhd5656@gmail.com)
 * @brief Programmers 과제하기(176962)
 * @version 0.1
 * @date 2023-04-01
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class SUBJECT {
private:
    string SUBJECT_NAME;
    int START_TIME;
    int REMAIN_TIME;

public:
    SUBJECT(string SUBJECT_NAME, int START_TIME, int REMAIN_TIME) {
        this->SUBJECT_NAME = SUBJECT_NAME;
        this->START_TIME = START_TIME;
        this->REMAIN_TIME = REMAIN_TIME;
    }

    void setRemianTime(int REMAIN_TIME) {
        this->REMAIN_TIME = REMAIN_TIME;
    }
    int getStartTime() {
        return this->START_TIME;
    }
    int getRemainTime() {
        return this->REMAIN_TIME;
    }
    string getSubjectName() {
        return this->SUBJECT_NAME;
    }
};

vector<string> solution(vector<vector<string>> plans);
bool compareObj(SUBJECT& n1, SUBJECT& n2);
int getTimeGap(int start, int end);

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    vector<int> timelaps;
    vector<SUBJECT> plansObj;
    vector<SUBJECT*> plansObjStack;

    // 객체저장
    for (vector<string> plan : plans) {
        SUBJECT subject(plan[0], stoi(plan[1].replace(plan[1].find(":"), 1, "")), stoi(plan[2]));
        plansObj.push_back(subject);
    }
    // 시작시간기준 sort
    sort(plansObj.begin(), plansObj.end(), compareObj);

    // ㅋㅅㅋ
    for (int i = 0; i < plansObj.size(); i++) {
        SUBJECT& plan = plansObj[i];
        // cout << plan.getStartTime() << endl;

        int next_i = (i + 1 >= plansObj.size()) ? -1 : i + 1;
        if (next_i != -1) {
            SUBJECT& next_plan = plansObj[next_i];

            // 현재 플랜과 다음 플랜 갭 구하기
            // int gap = next_plan.getStartTime() - plan.getStartTime();
            int gap = getTimeGap(plan.getStartTime(), next_plan.getStartTime());
            
            // gap과 현재플랜의 gap 구하기 갭에갭 ㅎ
            int gap_gap = plan.getRemainTime() - gap;

            // 딱맞게 끝나
            if (gap_gap == 0) {
                answer.push_back(plan.getSubjectName());
            }
            // 중간에 멈춰
            else if (gap_gap > 0) {
                // 스택쌓기
                plan.setRemianTime(gap_gap);
                plansObjStack.insert(plansObjStack.begin(), &plan);
            }
            // 시간이 남아
            else if (gap_gap < 0) {
                answer.push_back(plan.getSubjectName());
                
                // 남은시간을 스택꺼 돌리기
                int plansObjStackSize = plansObjStack.size();
                for (int j = 0; j < plansObjStack.size(); j++) {
                    if (gap_gap >= 0) break;
                    
                    SUBJECT* stack_plan = plansObjStack[j];
                    gap_gap = gap_gap + stack_plan->getRemainTime();
                    if (gap_gap > 0) {
                        stack_plan->setRemianTime(gap_gap);
                    }
                    else {
                        answer.push_back(stack_plan->getSubjectName());
                        plansObjStack.erase(plansObjStack.begin());
                        plansObjStackSize--;
                        j--;
                    }
                }
            }
        }
        else {
            answer.push_back(plan.getSubjectName());
        }
    }

    for (SUBJECT* subject : plansObjStack) {
        answer.push_back(subject->getSubjectName());
    }

    return answer;
}

bool compareObj(SUBJECT& n1, SUBJECT& n2) {
    return n1.getStartTime() < n2.getStartTime();
}

int getTimeGap(int start, int end) {
    int start_hour = start / 100;
    int start_min = start % 100;
    int end_hour = end / 100;
    int end_min = end % 100;
    
    int start_sec = (start_hour * 3600) + (start_min * 60);
    int end_sec = (end_hour * 3600) + (end_min * 60);
    int gap_sec = end_sec - start_sec;
    return gap_sec / 60;
}


int main() {

    vector<string> rtn;

    vector<vector<string>> plans = { {"science", "00:45", "50"},{"music", "00:25", "40"},{"history", "02:05", "30"},{"computer", "00:35", "100"} };

    rtn = solution(plans);
	
    for (string str : rtn) {
        cout << str << endl;
    }

	return 0;
}