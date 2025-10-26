#include <bits/stdc++.h>
using namespace std;
vector<int> v;
int n, p;

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> p;
        v.push_back(p);
    }

    sort(v.begin(), v.end());

    int time = 0;
    int total = 0;
    for(int i=0; i<v.size(); i++) {
        time += v[i];
        total += time;
    }

    cout << total;
}