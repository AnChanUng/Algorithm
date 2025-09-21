#include <bits/stdc++.h>
using namespace std;
int n, x;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> x;
            pq.push(x);
            if(pq.size() > n) {
                pq.pop();
            }
        }
    }
    cout << pq.top();
}