#include <bits/stdc++.h>
using namespace std;
int n;
int dp[100001];
int a[100001];
int main() {
    cin >> n;
    for(int i=1; i<=n; i++) {
        cin >> a[i];
    }
    
    dp[1] = a[1];
    for(int i=2; i<=n; i++) {
        dp[i] = max(a[i], dp[i-1] + a[i]);
    }
    
    cout << *max_element(dp+1, dp+n+1);
}