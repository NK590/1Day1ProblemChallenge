/*
	Baekjoon 토너먼트 (1057)
*/

#include <iostream>
#include <cmath>

using namespace std;
int main() {
	int n = 0; cin >> n;
	float a = 0; cin >> a;
	float b = 0; cin >> b;

	int stage = 1;
	while (true) {
		float a_divide = (a / 2);
		float b_divide = (b / 2);

		// 만났다
		// cout << ceil(a_divide) << endl;
		// cout << ceil(b_divide) << endl;
		if (ceil(a_divide) == b_divide || ceil(b_divide) == a_divide) {
			break;
		}

		a = ceil(a_divide);
		b = ceil(b_divide);

		stage++;
	}

	cout << stage << endl;
}