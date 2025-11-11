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
int n, m, x, y, color;
int dx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dy[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	
    for(test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n >> m; // 보드 한 변의 길이, 플레이어가 돌을 놓는 횟수
		vector<vector<int>> graph(n+1, vector<int>(n+1, 0));

		// 1.정가운데에 돌 놓기
		graph[n/2][n/2] = 2;
		graph[n/2][n/2+1] = 1;
		graph[n/2+1][n/2] = 1;
		graph[n/2+1][n/2+1] = 2;

		for(int i=0; i<m; i++) {
			// 돌을 놓을 위치, 돌의 색(1:흑, 2:백)
			cin >> x >> y >> color;

			// 2.(x,y) 돌 놓기
			graph[y][x] = color;
	
			// 3.돌을 놓았을 때 상태 변화..?
			// 가운데에 꼈을때 각 왼쪽, 오른쪽 돌=가운데 낀 돌로 변함
			for(int dir=0; dir<8; dir++) {
				int nx = y + dy[dir];
				int ny = x + dx[dir];
				vector<pair<int, int>> flip;

				while(nx >= 1 && nx <= n && ny >= 1 && ny <= n && graph[nx][ny] != 0) {
					if(graph[nx][ny] == color) {
						for(auto &p : flip) {
							graph[p.first][p.second] = color;
						}
						break;
					} else {
						flip.push_back({nx, ny});
					}
					nx += dy[dir];
					ny += dx[dir];
				}
			}
		}

		int black = 0, white = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j] == 1) black++;
				else if(graph[i][j] == 2) white++;
			}
		}

		cout << "#" << test_case << " " << black << " " << white << "\n";
	}
	return 0;
}