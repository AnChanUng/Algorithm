#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int n, nn;
/*
	묘묙 하나를 심는데 1일 걸림
	이장님을 초대 하는 가장 빠른 시간

	문제
	1.1 묘목의 수(n) 입력 받기
	1.2 n개 만큼 묘목이 걸리는 시간 입력 받기
	2   내림 차순 정렬
	3   

	접근 방식
	- 정렬->그리디 알고리즘
*/
int main()
{
	cin >> n;
	vector<int> v;
	for (int i = 0; i < n; i++) {
		cin >> nn;
		v.push_back(nn);
	}

	sort(v.begin(), v.end(), greater<int>());
	int cnt = 0;

	int idx = 0;
	int maxCnt = 0;
	for (int i = 0; i < v.size(); i++) {
		maxCnt = max(maxCnt, v[i] + i + 1 + 1);
	}
	cout << maxCnt;
	return 0;
}