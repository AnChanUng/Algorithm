#include <bits/stdc++.h>
using namespace std;
int n, m;
string site, pw, pwsite;
unordered_map<string, string> um;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;

    for(int i=0; i<n; i++) {
        cin >> site >> pw;
        um.insert({site, pw});
    }

    for(int i=0; i<m; i++) {
        cin >> pwsite;
        auto it = um.find(pwsite);
        if(it != um.end()) {
            cout << it->second << "\n";
        }
    }
}