#include <bits/stdc++.h>
using namespace std;
int arr[14];
vector<int> v;
/*
    문제
    1. 49개중에 6개 고르기

    접근 방식
    - 입력 값 중복 제거 조합
*/
void dfs(int depth, int start) {
    if(depth == 6) {
        for(int i=0; i<6; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    int used = INT_MIN;

    for(int i=start; i<v.size(); i++) {
        if(used != v[i]) {
            arr[depth] = v[i];
            dfs(depth+1, i+1);
        }
    } 
}

int main() {;
    while(true) {
        string line;
        getline(cin, line);
        if(line == "0" || line.empty()) break;

        stringstream ss(line);

        int k;
        ss >> k;

        v.clear();
        int x;
        while(ss >> x) {
            v.push_back(x);
        }
        dfs(0, 0);
        cout << "\n";
    }    
}