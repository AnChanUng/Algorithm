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

int n, m;
int x, y;
int answer;
vector<int> graph[11];
bool visited[11];

void dfs(int now, int depth) {
    visited[now] = true;
    answer = max(answer, depth);
    for (int next : graph[now]) {
        if (!visited[next]) {
            dfs(next, depth + 1);
        }
    }
    visited[now] = false; // 백트래킹
}

int main(int argc, char** argv) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T; 
    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case) {
        // 초기화
        for (int i = 0; i < 11; ++i) graph[i].clear();
        memset(visited, 0, sizeof(visited));
        answer = 0;

        cin >> n >> m;
        for (int i = 0; i < m; i++) {
            cin >> x >> y;
            graph[x].push_back(y);
            graph[y].push_back(x);
        }

        // 정점이 1 ~ n
        for (int i = 1; i <= n; i++) {
            dfs(i, 1);
        }

        cout << "#" << test_case << " " << answer << "\n";
    }
    return 0;
}