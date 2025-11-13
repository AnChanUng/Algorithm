/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// cin >> a;                            // int 변수 1개 입력받는 예제
// cin >> b >> c;                       // float 변수 2개 입력받는 예제 
// cin >> d >> e >> f;                  // double 변수 3개 입력받는 예제
// cin >> g;                            // char 변수 1개 입력받는 예제
// cin >> var;                          // 문자열 1개 입력받는 예제
// cin >> AB;                           // long long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// float b = 1.0, c = 2.0;               
// double d = 3.0, e = 0.0; f = 1.0;
// char g = 'b';
// char var[256] = "ABCDEFG";
// long long AB = 12345678901234567L;
// cout << a;                           // int 변수 1개 출력하는 예제
// cout << b << " " << c;               // float 변수 2개 출력하는 예제
// cout << d << " " << e << " " << f;   // double 변수 3개 출력하는 예제
// cout << g;                           // char 변수 1개 출력하는 예제
// cout << var;                         // 문자열 1개 출력하는 예제
// cout << AB;                          // long long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
#include <bits/stdc++.h>
using namespace std;
int n;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	/*
		7개의 정수 중 3개의 정수를 골라 합침 5번째로 큰 수

		문제
		1. t 입력받음
		1.1 7개의 정수 입력 받음
		2. 3개의 정수의 합을 구함
		2.1 3개의 정수를 벡터에 저장
		3. 5번째로 큰 수 출력

		접근 방식
		- 완전탐색으로 3 for문 3개의 합
	*/
    for(test_case = 1; test_case <= T; ++test_case)
	{
		vector<int> v;
		for(int i=0; i<7; i++) {
			cin >> n;
			v.push_back(n);
		}
		
		set<int> arr1;
		for(int i=0; i<v.size(); i++) {
			for(int j=i+1; j<v.size(); j++) {
				for(int k=j+1; k<v.size(); k++) {
					int sum = v[i] + v[j] + v[k];
					arr1.insert(sum);
				}
			}
		}

		vector<int> arr2(arr1.begin(), arr1.end());

		sort(arr2.begin(), arr2.end(), greater<int>());

		cout << "#" << test_case << " " << arr2[4] << "\n";
	}
	return 0;
}