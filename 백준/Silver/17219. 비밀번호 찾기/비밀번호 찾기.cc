#include <bits/stdc++.h>
using namespace std;
unordered_map<string, string> um;
int n, m;
string site, pw, findSite;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> site >> pw;
        um.insert({site, pw});
    }

    for(int i=0; i<m; i++) {
        cin >> findSite;
        auto it = um.find(findSite);
        if(it != um.end()) {
            cout << it->second << "\n";
        }
    }
}