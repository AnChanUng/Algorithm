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

/*
	

	문제
	
	
	접근 방식
	
*/
int main()
{
	int T;
	//cin >> T;
	for (int test_case = 1; test_case <= 10; ++test_case)
	{
		int n, nn;
		cin >> n;
		vector<int> v;
		for (int i = 0; i < n; i++) {
			cin >> nn;
			v.push_back(nn);
		}
		int total = 0;
		for (int i = 2; i < v.size() - 2; i++) {
			int maxLeft = *max_element(v.begin()+i-2, v.begin()+i);
			int maxRight = *max_element(v.begin()+i+1, v.begin()+i+3);
			int maxTotal = max(maxLeft, maxRight);
			if (v[i] - maxTotal > 0) {
				total += v[i] - maxTotal;
			} else {
				total += 0;
			}
		}
		cout << "#" << test_case << " " << total << "\n";
	}
	return 0;
}