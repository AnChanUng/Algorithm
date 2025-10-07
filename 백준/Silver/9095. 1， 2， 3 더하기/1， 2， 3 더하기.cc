#include <bits/stdc++.h>
using namespace std;
int t, n;
int dp[10001];
int main() {
    cin >> t;
    for(int i=0; i<t; i++) {
        cin >> n;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        cout << dp[n] << "\n";
    }
}