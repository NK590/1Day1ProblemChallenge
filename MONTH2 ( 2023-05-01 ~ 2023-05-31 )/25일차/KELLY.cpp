/*
	Programmers 예상대진표 (12985)
*/

#include <iostream>
#include <cmath>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;
	int stage = 1;
	float a_float = (float)a;
	float b_float = (float)b;
	while (true) {
		float a_divide = (a_float / 2);
		float b_divide = (b_float / 2);

		// 만났다
		// cout << ceil(a_divide) << endl;
		// cout << ceil(b_divide) << endl;
		if (ceil(a_divide) == b_divide || ceil(b_divide) == a_divide) {
			break;
		}

		a_float = ceil(a_divide);
		b_float = ceil(b_divide);

		stage++;
	}
    return stage;
}

int main() {
	int n = 8;
	int a = 4;
	int b = 7;
	cout << solution(n, a, b) << endl;
}