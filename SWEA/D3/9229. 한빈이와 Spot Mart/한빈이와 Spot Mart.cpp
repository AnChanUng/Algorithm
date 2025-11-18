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
#include <algorithm>
#include <vector>
using namespace std;
int n, m, nn;
/*
	n개의 과자 봉지
	각 a그램의 무게
	두 봉지의 무게가 m그람 초과하면 안됨
	한빈이가 들고 다닐 수 있는 최대 무게 합 출력

	문제
	1.1 tc 입력 받기
	1.2 과자 봉지 개수(n), 무게 합 제한(m) 입력 받기
	1.3 n개의 줄에 과자 봉지 무게 입력 받기
	2.1 m을 초과하지 않는 2개의 봉지를 고름
	3.1 최대 값 출력
	
	접근 방식
	
*/
int main()
{
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> m;
		vector<int> v;
		for (int i = 0; i < n; i++) {
			cin >> nn;
			v.push_back(nn);
		}
		int maxTotal = -1;
		for (int i = 0; i < v.size(); i++) {
			int total = 0;
			for (int j = i + 1; j < v.size(); j++) {
				total = v[i] + v[j];
				if (total <= m) {
					maxTotal = max(maxTotal, total);
				}
			}
		}
		cout << "#" << test_case << " " << maxTotal << "\n";
	}
	return 0;
}