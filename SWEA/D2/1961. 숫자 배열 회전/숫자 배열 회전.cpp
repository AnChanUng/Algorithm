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
int t, n;
int main() {
    cin >> t;
    for(int test_case=1; test_case<=t; test_case++) {
        cin >> n;
        vector<vector<int>> graph(n, vector<int>(n));

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                cin >> graph[i][j];
            }
        }
        
        vector<vector<int>> graph_90(n, vector<int>(n));
        vector<vector<int>> graph_180(n, vector<int>(n));
        vector<vector<int>> graph_270(n, vector<int>(n));

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph_90[i][j] = graph[n-j-1][i];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph_180[i][j] = graph_90[n-j-1][i];
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph_270[i][j] = graph_180[n-j-1][i];
            }
        }

        cout << "#" << test_case << "\n";
        for(int i=0; i<n; i++) {
            for(int a=0; a<n; a++) {
                cout << graph_90[i][a];
            }
            cout << " ";
            
            for(int b=0; b<n; b++) {
                cout << graph_180[i][b];
            }
            cout << " ";

            for(int c=0; c<n; c++) {
                cout << graph_270[i][c];
            }
            cout << "\n";
        }
    }    
}