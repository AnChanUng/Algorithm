#include <bits/stdc++.h>
using namespace std;
int n, m;
int main() {
    cin >> n >> m;
    vector<vector<int>> graph(n, vector<int>(m));
    for(int i=0; i<n; i++) {
        string s;
        cin >> s;
        for(int j=0; j<m; j++) {
            graph[i][j] = s[j] - '0';
        }
    }
    // 네 꼭지점의 숫자가 같아야합니다.
    int ans = 1;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            for(int k=1; i+k<n && j+k<m; k++) {
                if(graph[i][j] == graph[i+k][j] && graph[i][j] == graph[i][j+k] && graph[i][j] == graph[i+k][j+k]) {
                    ans = max(ans, (k+1) * (k+1));
                }
            }
        }
    }
    cout << ans;
}