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
int wordLength;
string word;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	//cin>>T;
	/*
		문제
		1. 10개의 test_case를 입력받음
		1.1 문자열의 길이와 문자열을 입력 받음
		2. 현재 위치와 현재위치+1을 탐색, 같으면 삭제 후 위치 -1
		2.1 다르면 continue

		접근 방식
		- 완전탐색으로 현재 위치의 문자열과 오른쪽의 문자열이 같으면 
		- 두 문자열을 삭제 후, 현재 위치-1 하고 다시 탐색
	*/
    for(test_case = 1; test_case <= 10; ++test_case)
	{
		cin >> wordLength >> word;

		string tmp = word;
		int idx = 0;
		while(idx+1 < tmp.size()) {
			if(tmp[idx] == tmp[idx+1]) {
				tmp.erase(idx, 2);
				if(idx > 0) idx--;
			} else {
				idx++;
			}
		}

		cout << "#" << test_case << " " << tmp << "\n";
	}
	return 0;
}