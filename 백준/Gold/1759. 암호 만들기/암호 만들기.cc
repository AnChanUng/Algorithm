#include <bits/stdc++.h>
using namespace std;
int l, c;
string arr[17];
string moeum[5] = {"a", "e", "i", "o", "u"};
vector<string> v;

/*
    암호: L개의 알파벳 소문자로 구성
    1개의 모음과 2개의 자음으로 구성

    문제
    1.  l c 입력받기
    1.1 c개의 문자들 입력받기
    2.  최소 1개의 모음 + 2개 이상의 자음으로 구성

    접근 방식
    - 조합
*/

bool isMoeum(string c) {
    return c == "a" || c == "e" || c == "i" || c == "o" || c == "u";
}

void dfs(int depth, int start) {
    if(depth == l) {
        int moeum;
        int jaeum; 

        for(int i=0; i<l; i++) {
            if(isMoeum(arr[i])) moeum++;
            else jaeum++;
        }

        if(moeum >= 1 && jaeum >= 2) {
            for(int i=0; i<l; i++) {
                cout << arr[i];
            }
            cout <<"\n";
            return;
        }
    }
    
    for(int i=start; i<v.size(); i++) {
        arr[depth] = v[i];
        dfs(depth+1, i+1);
    }
}

int main() {;
    cin >> l >> c;
    for(int i=0; i<c; i++) {
        string st;
        cin >> st;
        v.push_back(st);
    }
    sort(v.begin(), v.end());
    
    dfs(0, 0);
    
    return 0;
}