#include <bits/stdc++.h>
using namespace std;
int n, k, b, x;

int main() {
    cin >> n >> k >> b;
    vector<int> psum(n+1, 0);
    vector<int> broken(n+1, 0);
    
    for(int i=0; i<b; i++) {
        cin >> x;
        broken[x] = 1;
    }
    
    for(int i=1; i<=n; i++) {
        psum[i] = psum[i-1] + broken[i];
    }

    int answer = INT_MAX;
    for(int i=1; i <=n-k+1; i++) {
        int brokenCount = psum[i+k-1] - psum[i-1];
        answer = min(answer, brokenCount);
    }
    
    cout << answer;
    return 0;
}