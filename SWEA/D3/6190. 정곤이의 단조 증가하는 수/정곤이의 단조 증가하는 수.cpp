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
int n, a;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	/*
		단조 증가하는 수인 것을 구하고 최대값 출력

		문제
		1. 테스트케이스 개수 입력 받기
		1.1 n 입력받기
		1.2 n개 만큼 증가하는 수 입력 받기
		2. 모든 경우의 수에 대해 v[i] * v[i+1]
		3. 해당 수가 단조면 v에 저장
		4. v를 내림 차순 후 v[0] 출력
		4.1 v.size() == 0이면 -1 출력

		접근 방식
		- 모든 경우의 수를 탐색하며 v[i] * v[i+1] 곱함
		- 곱한 수가 단조면 저장
	*/
    for(test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;
		vector<int> v;
		for(int i=0; i<n; i++) {
			cin >> a;
			v.push_back(a);
		}

		vector<int> arr;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int tmp = v[i] * v[j];
				string wtmp = to_string(tmp);
				
				bool flag = false;
				if(wtmp.size() == 1) {
					flag = true;
					continue;
				} else {
					for(int i=0; i<wtmp.size()-1; i++) {
						if(wtmp[i] <= wtmp[i+1]) {
							flag = true;
						} else {
							flag = false;
							break;
						}
					}
				}

				if(flag == true) {
					arr.push_back(tmp);
				}
			}
		}
		sort(arr.begin(), arr.end(), greater<int>());
		
		int answer = 0;
		if(arr.size() == 0) {
			answer = -1;
		} else {
			answer = arr[0];
		}

		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}