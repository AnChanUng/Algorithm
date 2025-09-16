#include <bits/stdc++.h>
using namespace std;
int n, m;
string s1,s2;
unordered_set<string> keywords;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    // 키워드의 개수, 글의 개수
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> s1;
        keywords.insert(s1);
    }
    for(int j=0; j<m; j++) {
        cin >> s2;
        string token;
        stringstream ss(s2);

        while(getline(ss, token, ',')) {
            keywords.erase(token);
        }
        cout << keywords.size() << "\n";
    }
}