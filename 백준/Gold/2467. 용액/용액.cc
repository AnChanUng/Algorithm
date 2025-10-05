#include <bits/stdc++.h>
using namespace std;
int n, val;
int minVal = INT_MAX;
vector<long long> v;
pair<long long, long long> ans;
int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> val;
        v.push_back(val);    
    }
    int left = 0;
    int right = n - 1;
    long long minVal = LLONG_MAX;
    
    while(left < right) {
        long long sum = v[left] + v[right];
        if(abs(sum) < minVal) {
            minVal = abs(sum);
            ans = {v[left], v[right]};
        }
        if(sum > 0) right--;
        else left++;
    }
    
    cout << ans.first << " " << ans.second;
}