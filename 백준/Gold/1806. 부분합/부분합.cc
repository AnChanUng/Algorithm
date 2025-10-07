#include <bits/stdc++.h>
using namespace std;
int n, s, a;
vector<int> v;

int main() {
    cin >> n >> s;
    for(int i=0; i<n; i++) {
        cin >> a;
        v.push_back(a);
    }
    int left=0, right=0;
    int sum = 0;
    int minLen = INT_MAX;
    
    while(true) {
        if(sum >= s) {
            minLen = min(minLen, right - left);
            sum -= v[left++];
        } else if (right == n) { 
            break;
        } else {
            sum += v[right++];
        }
    }
    if(minLen == INT_MAX) {
        cout << 0;
    } else {
        cout << minLen;
    }
}