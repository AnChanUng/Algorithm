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
vector<string> check = {"ooooo"};

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	
    for(test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;
		vector<string> graph(n);

		for(int i=0; i<n; i++) {
			cin >> graph[i];
		}
		
		string answer = "NO";
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=graph[i].size()-5; j++) {
				string s = graph[i].substr(j, 5);
				if(s == check[0]) {
					answer = "YES";
					break;
				}
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<=n-5; j++) {
				string result = "";
				
				for(int k=0; k<5; k++) {
					result += graph[j+k][i];
				}

				if(result == check[0]) {
					answer = "YES";
					break;
				}
			}
		}

        for(int r=0; r<=n-5; r++) {
            for(int c=0; c<=n-5; c++) {
                string s = "";
                for(int k=0; k<5; k++) { 
					s += graph[r + k][c + k];
				}
				if(s == check[0]) { 
					answer = "YES"; 
					break; 
				}
            }
        }

        for(int r=4; r<n; r++) {
            for(int c=0; c<=n-5; c++) {
                string s = "";
                for(int k=0; k<5; k++) {
					s += graph[r - k][c + k];
				}
				if(s == check[0]) { 
					answer = "YES"; 
					break; 
				}
            }
        }
		
		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}