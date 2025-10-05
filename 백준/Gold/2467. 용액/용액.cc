#include <bits/stdc++.h>
using namespace std;
int n, val;
vector<int> v;
pair<int, int> ans;
int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> val;
        v.push_back(val);
    }
    sort(v.begin(), v.end());
    
    int left = 0;
    int right = n-1;
    int maxVal = INT_MAX;

    while(left < right) {
        int sum = v[left] + v[right];
        if(abs(sum) < maxVal) {
            maxVal = abs(sum);
            ans = {v[left], v[right]};
        }
        if(sum > 0) {
            right--;
        } else {
            left++;
        }
    }
    cout << ans.first << " " << ans.second;
}