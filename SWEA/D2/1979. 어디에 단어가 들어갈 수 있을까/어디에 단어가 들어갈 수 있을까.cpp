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
int n, k;
int graph[16][16];
int answer;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	/*
		모든 칸에서 1이 연속되는 부분의 길이를 체크해서 연속되는 부분과
		k가 같으면 cnt++;
		
		문제
		1.1 t 입력 받음
		1.2 n, k 입력 받음
		1.3 n줄에 2차원 정보 입력받음
		2.  흰색 부분이 k개면 cnt++
		3.  cnt++ 출력

		접근 방식
		- 모든 경우의 수 탐색, 연속해서 1인 부분 k면 cnt++
	*/
    for(test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> k;
		answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cin >> graph[i][j];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-k+1; j++) {
				int colCnt = 0;
				if(j == 0 && graph[i][j] == 1 && graph[i][j+k] == 0 || j > 0 && graph[i][j] == 1 && graph[i][j-1] == 0 && graph[i][j+k] == 0) {
					for(int l=0; l<n; l++) {
						if(graph[i][j+l] == 1) {
							colCnt++;
						} else {
							break;
						}
					}
				}
				if(colCnt == k) {
					answer++;
					//cout << "colCnt: " << i << " " << j << " answer: " << answer << "\n";
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-k+1; j++) {
				int rowCnt = 0;
				if(j== 0 && graph[j][i] == 1 && graph[j+k][i] == 0 || j > 0 && graph[j][i] == 1 && graph[j+k][i] == 0 && graph[j-1][i] == 0) {
					for(int l=0; l<n; l++) {
						if(graph[j+l][i] == 1) {
							rowCnt++;
						} else {
							break;
						}
					}
				}
				if(rowCnt == k) {
					answer++;
					//cout << "rowCnt: " << i << " " << j << " answer: " << answer << "\n";
				}
			}
		}
		cout << "#" << test_case << " " << answer << "\n";
	} 
	return 0;
}