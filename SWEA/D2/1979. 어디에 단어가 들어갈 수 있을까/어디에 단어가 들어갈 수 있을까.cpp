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
int t, n, s;

int main() {
    cin >> t;
    for(int test_case=1; test_case<=t; test_case++) {
        cin >> n >> s; // 가로, 세로
        int graph[16][16];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                cin >> graph[i][j];
            }
        }
        int total = 0; // 가로 개수 카운트
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int garoCnt = 0;
                if(graph[i][j] == 1) {
                    for(int k=j; k<n; k++) {
                        if(graph[i][k] == 1) {
                            garoCnt++;
                        } else {
                            break;
                        }
                    }
                }
                if(garoCnt == s) { 
                    if(j == 0 || graph[i][j-1] == 0) total++; 
                }
            }
        }
        //세로 개수 카운트
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int seroCnt = 0;
                if(graph[j][i] == 1) {
                    for(int k=j; k<n; k++) {
                        if(graph[k][i] == 1) {
                            seroCnt++;
                        } else {
                            break;
                        }
                    }
                }
                if(seroCnt == s) { 
                    if(j == 0 || graph[j-1][i] == 0) total++;
                }
            }
        }
        cout << "#" << test_case << " " << total << "\n";
    }    
}