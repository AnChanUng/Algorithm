#include <bits/stdc++.h>
using namespace std;
int n, maxNumber = 0;
int dp[501][501];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    for(int i=0; i<n; i++) {
        for(int j=0; j<=i; j++) {
            cin >> dp[i][j];
        }
    }
    for(int i=1; i<n; i++) {
        for(int j=0; j<=i; j++) {
            if(j == 0) {
                dp[i][j] += dp[i-1][j];          
            } else if (j == i) {
                dp[i][j] += dp[i-1][j-1];        
            } else {
                dp[i][j] += max(dp[i-1][j-1], dp[i-1][j]); 
            }
        }
    }
    for(int j=0; j<n; j++) {
        maxNumber = max(maxNumber, dp[n-1][j]);
    }
    cout << maxNumber;
}