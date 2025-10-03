#include <bits/stdc++.h>
using namespace std;
string s, t;
bool flag = false;

void dfs(string cur) {
    if(cur == s) { 
        flag = true;
        return;
    }
    if(cur.size() < s.size()) return;
    if(!cur.empty() && cur.back() == 'A') {
        string next = cur;
        next.pop_back();
        dfs(next);
    }
    if(!cur.empty() && cur.front() == 'B') {
        string next = cur;
        reverse(next.begin(), next.end());
        next.pop_back();
        dfs(next);
    }
}

int main() {
    cin >> s;
    cin >> t;
    dfs(t);
    if(flag) cout << 1;
    else cout << 0;
}