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
int n, test;
int tmp;
int main(int argc, char** argv)
{
	int test_case;
	//int T;

	//cin>>T;
	
    for(test_case = 1; test_case <= 10; ++test_case)
	{
		cin >> test;
		queue<int> q;
		for(int i=0; i<8; i++) {
			cin >> n;
			q.push(n);
		}
		int number = 0;
		while(true) {
			number++;

			auto cur = q.front(); 
			q.pop();
			if(number % 5 == 0) {
				tmp = cur - 5;
			} else {
				tmp = cur - (number % 5);
			}

			if(tmp <= 0) {
				q.push(0);
				break;
			} else {
				q.push(tmp);
			}
			// 8개의 숫자 입력 받기
			// Queue에 저장
			// 맨 앞 1감소 후 맨 뒤로 보냄 (5번 반복)
			// 맨 앞 2감소 후 맨 뒤로 보냄 (5번 반복)
			// 맨 앞에 수가 0이 되면 맨 뒤로 0을 보내고 종료
		}

		cout << "#" << test_case << " ";
		while(!q.empty()) {
			cout << q.front() << " ";
			q.pop();
		}
		cout << "\n";
	}
	return 0;
}