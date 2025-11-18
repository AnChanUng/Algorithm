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
#include <algorithm>
#include <vector>
using namespace std;
vector<string> alpha = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
/*
	원하는 문자열을 입력받아 문자를 숫자로 변경했을 때, 값으로 오름차순 정렬

	문제
	1.1 테스트 케이스(t) 입력 받기
	1.2 #1 숫자 입력 받기 
	1.3 문자열 입력 받기
	2 1 입력 받은 문자열 숫자로 변경
	2.2 오름 차순 정렬
	2.3 각 숫자를 문자로 변경
	3.1 출력
	
	접근 방식
	
*/
int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; ++test_case)
	{
		string tc, str;
		int tcLen;
		cin >> tc >> tcLen;
		vector<int> v;
		for (int i = 0; i < tcLen; i++) {
			cin >> str;
			auto it = find(alpha.begin(), alpha.end(), str);
			if (it != alpha.end()) {
				int tmp = it - alpha.begin();
				v.push_back(tmp);
			}
		}

		sort(v.begin(), v.end());

		cout << tc << "\n";
		for (int i = 0; i < v.size(); i++) {
			string ttmp = alpha[v[i]];
			cout << ttmp << " ";
		}
	}
	return 0;
}