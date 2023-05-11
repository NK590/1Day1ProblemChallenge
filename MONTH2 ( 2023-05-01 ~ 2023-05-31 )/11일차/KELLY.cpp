/*
	Baekjoon ���� (1026)
*/

#include <iostream>

#include <vector>
#include <algorithm>

using namespace std;

bool sort_desc_proc(int a, int b);
int main() {
	/**
	ù° �ٿ� N�� �־�����. 
	��° �ٿ��� A�� �ִ� N���� ���� ������� �־�����, 
	��° �ٿ��� B�� �ִ� ���� ������� �־�����. 
	
	N�� 50���� �۰ų� ���� �ڿ����̰�, A�� B�� �� ���Ҵ� 100���� �۰ų� ���� ���� �ƴ� �����̴�.
	*/
	int result = 0;

	int N = 0; cin >> N;
	vector<int> A, B;

	// A �Է¹ޱ�
	for (int i = 0; i < N; i++) {
		int n = 0; cin >> n;
		A.push_back(n);
	}

	// B �Է¹ޱ�
	for (int i = 0; i < N; i++) {
		int n = 0; cin >> n;
		B.push_back(n);
	}

	// A �������� ����
	sort(A.begin(), A.end());
	// B �������� ����
	sort(B.begin(), B.end(), sort_desc_proc);


	// S = A[0] �� B[0] + ... + A[N-1] �� B[N-1]
	for (int i = 0; i < N; i++) {
		result += A[i] * B[i];
	}

	// ���
	cout << result << endl;
}

bool sort_desc_proc(int a, int b) {
	return a > b;
}