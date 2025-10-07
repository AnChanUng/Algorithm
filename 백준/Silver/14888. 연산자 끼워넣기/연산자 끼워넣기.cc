#include <bits/stdc++.h>
using namespace std;
int n;
int e, f, g, h;
int maxValue = INT_MIN;
int minValue = INT_MAX;
int a[12], b[4];

void calculate(int idx, int cur, int plus, int minus, int multi, int div) {
    if(idx == n-1) {
        maxValue = max(cur, maxValue);
        minValue = min(cur, minValue);
        return;
    }
    if(plus) calculate(idx+1, cur+a[idx+1], plus-1, minus, multi, div);
    if(minus) calculate(idx+1, cur-a[idx+1], plus, minus-1, multi, div);
    if(multi) calculate(idx+1, cur*a[idx+1], plus, minus, multi-1, div);
    if(div) calculate(idx+1, cur/a[idx+1], plus, minus, multi, div-1);
    return;
}

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> a[i];
    }
    cin >> e >> f >> g >> h;

    calculate(0, a[0], e, f, g, h);

    cout << maxValue << "\n";
    cout << minValue;
}