#include <bits/stdc++.h>
using namespace std;
int arr[1001];
int max_pos, max_h;
int n, l, h; // 기둥의 개수, 왼쪽면의 위치, 높이
int res = 0;
int main() {
    cin >> n; 
    for(int i=0; i<n; i++) {
        cin >> l >> h;
        arr[l] = h;
        if(max_h < h) {
            max_pos = l;
            max_h = h;
        }
    }

    int lh=0;
    for(int i=1; i<max_pos; i++) {
        lh = max(lh, arr[i]);
        res += lh;
    }

    int rh=0;
    for(int i=1000; i>max_pos; i--) {
        rh = max(rh, arr[i]);
        res += rh;
    }
    cout << res + max_h;
}