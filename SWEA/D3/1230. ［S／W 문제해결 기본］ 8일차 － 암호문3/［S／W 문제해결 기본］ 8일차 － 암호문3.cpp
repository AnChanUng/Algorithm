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
int n, resource, orderNum, x, y, s;
string order;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	//cin>>T;
	/*
		암호문을 삽입, 삭제, 추가함

		문제
		1. 암호문의 개수 입력 받기
		1.1 원본 암호문 뭉치 입력 받기
		1.2 명령어의 개수 입력 받기
		1.3 명령어 입력 받기
		2. 명령어 I이면 x번째 암호문 바로 다음에 y개의 암호문 삽입
		2.1 명령어 D면 x번째 암호문 바로 다음에 y개의 암호문 삭제
		2.2 명령어 A면 암호문 뭉치 맨 뒤에 y개의 암호문 추가
		3. 앞에 10개 출력

		접근 방식
		- 
	*/
    for(test_case = 1; test_case <= 10; ++test_case)
	{
		cin >> n;
		vector<int> v;
		for(int i=0; i<n; i++) {
			cin >> resource;
			v.push_back(resource);
		}
		cin >> orderNum;
		for(int i=0; i<orderNum; i++) {
			cin >> order;
			if(order == "I") {
				cin >> x;
				cin >> y;
				for(int j=0; j<y; j++) {
					cin >> s;
					v.insert(v.begin() + x + j, s);
				}
			} else if (order == "D") {
				cin >> x;
				cin >> y;
				for(int j=0; j<y; j++) {
					v.erase(v.begin() + x);
				}
			} else if (order == "A") {
				cin >> y;
				for(int j=0; j<y; j++) {
					cin >> s; 
					v.push_back(s);
				}
			}
		}
		cout << "#" << test_case << " ";
		for(int i=0; i<10; i++) {
			cout << v[i] << " ";
		}
		cout << "\n";
	}
	return 0;
}