#include <bits/stdc++.h>
using namespace std;
int n, k;
int a;
int d[200002];
int checkCnt[200002];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> k;
    for(int i=0; i<n; i++) {
        cin >> d[i];
    }
    int left = 0;
    int right = 0;
    int maxValue = 0;
    while(right < n) {
        if(checkCnt[d[right]] < k) {
            checkCnt[d[right]]++;
            right++;
        } else {
            maxValue = max(maxValue, right - left);
            checkCnt[d[left]]--;
            left++;
        }
    }
    maxValue = max(maxValue, right - left);
    cout << maxValue;
}