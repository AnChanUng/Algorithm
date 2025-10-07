#include <bits/stdc++.h>
using namespace std;
int n, k;
int dp[101][100001];
int w[101], v[101];
int main() {
    cin >> n >> k; // 물품 수, 무게
    for(int i=1; i<=n; i++) {
        cin >> w[i] >> v[i]; // 무게, 가치
    }

    for(int i=1; i<=n; i++) {
        for(int j=0; j<=k; j++) {
            dp[i][j] = dp[i-1][j];
            if(j >= w[i]) {
                dp[i][j] = max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
            }
        }
    }
    cout << dp[n][k];
} 