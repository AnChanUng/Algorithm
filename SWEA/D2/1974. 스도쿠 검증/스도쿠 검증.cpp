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
int t;
int main() {
    cin >> t;
    int graph[10][10];
    for(int test_case=1; test_case<=t; test_case++) {
        int answer = 1;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                cin >> graph[i][j];
            }
        }
        // 가로
        for(int i=0; i<9; i++) {
            int garoSum = 0;
            for(int j=0; j<9; j++) {
                garoSum += graph[i][j];
            }
            if(garoSum != 45) { 
                answer = 0;
                break;
            }
        }

        // 세로
        for(int i=0; i<9; i++) {
            int seroSum = 0;
            for(int j=0; j<9; j++) {
                seroSum += graph[j][i];
            }
            if(seroSum != 45) { 
                answer = 0;
                break;
            }
        }
        // 3*3
        for(int i=0; i<9; i+=3) {
            for(int j=0; j<9; j+=3) {
                int total = 0;
                for(int a=0; a<3; a++) {
                    for(int b=0; b<3; b++) {
                        total += graph[i+a][j+b];
                        //cout << "i+a: " << i+a << " j+b: " << j+b << "\n";
                    }    
                }
                if(total != 45) {
                    answer = 0;
                    break;
                }
            }
        }
        cout << "#" << test_case << " " << answer << "\n";
    }
}