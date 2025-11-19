#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int n, k, nn;
/*
	문제
	1.1 센서의 개수(n) 입력 받기
	1.2 집중국의 개수(k) 입력 받기
	1.3 n개의 줄에 센서 좌표 입력 받기
	2   센서좌표 벡터 정렬
	3   센서[i+1] - 센서[i] 배열 만들기
	3   내림차순 정렬
	4   앞에서 K - 1개 제거
	5   남은 diff의 합 

	접근 방식
	- 정렬 후, 그리디 알고리즘
*/
int main() {
	cin >> n;
	cin >> k;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		cin >> nn;
		v.push_back(nn);
	}
	sort(v.begin(), v.end());

	vector<int> diff;
	for (int i = 0; i < v.size()-1; i++) {
		int tmp = v[i + 1] - v[i];
		diff.push_back(tmp);
	}

	sort(diff.begin(), diff.end(), greater<int>());
	
	int result = 0;
	for (int i = k-1; i < diff.size(); i++) {
		result += diff[i];
	}
	cout << result;
}