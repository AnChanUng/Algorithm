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
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
/*
	문제
	1.1 테스트 케이스 수(t) 입력 받기
	1.2 5개 줄에 문자열 입력 받기
	2.1 세로로 하나씩 출력하기
	2.2 존재하지 않으면 건너뛰고 출력

	접근 방식
	- 완전탐색
*/
int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; ++test_case)
	{
		string str;
		vector<string> v;
		int maxstrLen = 0;
		for (int i = 0; i < 5; i++) {
			cin >> str;
			maxstrLen = max((int)str.size(), maxstrLen);
			v.push_back(str);
		}

		cout << "#" << test_case << " ";
		for (int i = 0; i < maxstrLen; i++) {
			for (int j = 0; j < 5; j++) {
				if(i < v[j].size()) {
					cout << v[j][i];
				} else {
					continue;
				}
			}
		}
		cout << "\n";
	}
	return 0;
}