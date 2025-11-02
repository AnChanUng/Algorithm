#include <bits/stdc++.h>
using namespace std;
int n, k, b;
int x;

vector<int> broken(100001, 0);
vector<int> psum(100001, 0);
int main() {
    cin >> n >> k >> b;
    for(int i=0; i<b; i++) {
        cin >> x;
        broken[x] = 1;
    }
    int cur = 0;
    for(int i=1; i<=k; i++) {
        cur += broken[i];
    }

    int answer = cur;
    for(int i=1; i<=n-k; i++) {
        cur = cur + broken[i+k] - broken[i];
        answer = min(answer, cur);
    }

    cout << answer;
}