#include <bits/stdc++.h>
using namespace std;
string s, t;
int main() {
    cin >> s;
    cin >> t;

    while(s.size() < t.size()) {
        if(t.back() == 'A') {
            t.pop_back();
        } else {
            t.pop_back();
            reverse(t.begin(), t.end());
        }
    }
    if(s == t) {
        cout << 1;
    } else {
        cout << 0;
    }
}