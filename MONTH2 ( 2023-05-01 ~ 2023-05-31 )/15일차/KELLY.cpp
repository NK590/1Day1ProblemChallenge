/*
	Baekjoon 그룹 단어 체커 (1316)
*/

#include <iostream>
#include <string>
#include <vector>

/*
	앞서 나온 문자가 다시 나오면 그룹단어가 아님
*/
using namespace std;

class Case {
private:
	string str = "";
	bool isGroup = false;

public:
	Case() { this->str = ""; this->isGroup = false; }
	Case(string _str) { this->str = _str; this->isGroup = false; }

	/* 그룹단어인지 셋팅 */
	void setIsGroup() {
		string tempStr = this->str;
		bool resultBool = true;
		int index = 0;
		int findCharIndex = NULL;

		while (index < (tempStr.length() - 1)) {

			findCharIndex = tempStr.find(tempStr[index], (index + 1));
			if (findCharIndex != string::npos) {
				if (findCharIndex != (index + 1)) {
					resultBool = false;
					break;
				}
			}

			index++;
		}

		this->isGroup = resultBool;

	}
	bool getIsGroup() { return this->isGroup; }
};


int main() {
	int testCase = 0;
	int count = 0;
	vector<Case> inputCase;
	vector<Case>::iterator iter;
	string str = "";

	cin >> testCase;

	for (int i = 0; i < testCase; i++) {
		cin >> str;

		inputCase.push_back(Case(str));
	}


	for (iter = inputCase.begin(); iter < inputCase.end(); iter++) {
		(*iter).setIsGroup();

		if ((*iter).getIsGroup()) {
			count++;
		}
	}

	cout << count << endl;

	return 0;
}