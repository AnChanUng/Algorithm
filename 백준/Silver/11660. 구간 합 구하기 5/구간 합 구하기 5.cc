#include <bits/stdc++.h>
using namespace std;
int n, m;
int a1, b1, a2, b2;
int graph[1025][1025];
int psum[1025][1025];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            cin >> graph[i][j];
        }
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            psum[i][j] = graph[i][j] + psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1];
        }
    }
    
    for(int i=0; i<m; i++) {
        cin >> a1 >> b1 >> a2 >> b2;
        int answer = psum[a2][b2] - psum[a1-1][b2] - psum[a2][b1-1] + psum[a1-1][b1-1];
        cout << answer << "\n";
    }
}