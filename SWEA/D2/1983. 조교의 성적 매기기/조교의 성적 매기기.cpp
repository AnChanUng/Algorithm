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
int t, n, k;
int midExam, finalExam, homework;
string score[10] = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

int main() {
    cin >> t;
    for(int test_case=1; test_case<=t; test_case++) {
        cin >> n >> k; // 학생수, 학생의 번호
        
        vector<pair<double, int>> v;
        for(int i=1; i<=n; i++) {
            cin >> midExam >> finalExam >> homework;
            double total = midExam * 0.35 + finalExam * 0.45 + homework * 0.2;
            v.push_back({total, i});
        }
        string answer;
        sort(v.begin(), v.end(), greater<pair<double, int>>());

        for(int i=0; i<v.size(); i++) {
            if(v[i].second == k) {
                int nn = n / 10;
                int temp = i / nn;
                answer = score[temp];
                break;
            }
        }
        cout << "#" << test_case << " " << answer << "\n";
        // for(int i=0; i<v.size(); i++) {
        //     cout << v[i].first << " " << v[i].second << "\n";
        // }
    }
}