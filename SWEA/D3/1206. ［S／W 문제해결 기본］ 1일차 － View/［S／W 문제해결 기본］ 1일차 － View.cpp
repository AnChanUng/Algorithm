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
int n, h;
int main() {
    for(int test_case=1; test_case<=10; test_case++) {
        cin >> n;
        vector<int> v;
        for(int i=0; i<n; i++) {
            cin >> h; // 건물의 높이
            v.push_back(h);
        }
        int answer = 0;
        for(int i=2; i<v.size(); i++) {
            // 본인의 위치에서 왼쪽두칸과 오른쪽 두칸이 본인보다 작으면 그 차이의 -2만큼 저장
            // 본인 기준 왼쪽에서 가장 큰거
            int leftHeight = *max_element(v.begin()+i-2, v.begin()+i);
            //cout << "i: " << i << " lh:" << leftHeight << "\n"; 
            // 본인 기준 오른쪽에서 가장 큰거
            int rightHeight = *max_element(v.begin()+i+1, v.begin()+i+3);
            // 그 두개중에 더 큰거
            int maxHeight = max(leftHeight, rightHeight); 
            // 본인의 크기 > 최대높이
            if(maxHeight < v[i]) {
                // answer += 본인의크기-최대의높이
                answer += v[i] - maxHeight; 
            }
        }
        cout << "#" << test_case << " " << answer << "\n";
    }
}