/*
Programmers 최솟값 만들기 (12941)
*/

#include <iostream>

#include <vector>
#include <algorithm>

static int DESCEND = 0;
static int ASCEND = 1;

using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;

    //for (int i = 0; i < A.size(); i++) {
    //    for (int j = i + 1; j < A.size(); j++) {
    //        // A 정렬
    //        if (A[i] > A[j]) {
    //            int temp = A[i];
    //            A[i] = A[j];
    //            A[j] = temp;
    //        }

    //        // B 정렬
    //        if (B[i] < B[j]) {
    //            int temp = B[i];
    //            B[i] = B[j];
    //            B[j] = temp;
    //        }
    //    }
    //}

    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    for (int i = 0; i < A.size(); i++) {
        answer += A[i] * B[B.size() - i - 1];
    }


    return answer;
}

int main() {
    vector<int> A = { 1, 4, 2 };
    vector<int> B = { 5, 4, 4 };

    cout << solution(A, B) << endl;
}