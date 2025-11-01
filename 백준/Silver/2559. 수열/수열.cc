#include <bits/stdc++.h>
using namespace std;
int n, k;
vector<int> arr(100001, 0);
vector<int> psum(100001, 0);

int main() {
    cin >> n >> k;
    for(int i=0; i<n; i++) {
        cin >> arr[i];
    }
    int total = 0;
    for(int i=0; i<k; i++) {
        total += arr[i];
    }
    psum[0] = total;
    
    for(int i=1; i<n-k+1; i++) {
        psum[i] = psum[i-1] + arr[i+k-1] - arr[i-1];
    }
    int maxNum = *max_element(psum.begin(), psum.begin()+n-k+1);

    cout << maxNum;
}