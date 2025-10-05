#include <bits/stdc++.h>
using namespace std;
int h, w, bh;
int res;
vector<int> v;
int main() {
    cin >> h >> w;
    for(int i=0; i<w; i++) {
        cin >> bh; // 블록이 쌓인 높이
        v.push_back(bh);
    }

    for(int i=1; i<v.size()-1; i++) {
        int maxLeft = *max_element(v.begin(), v.begin()+i);
        int maxRight = *max_element(v.begin()+i, v.end());
        // cout << maxLeft << " " << maxRight << "\n";
        // 고이는 물 = min(왼쪽 최고 높이, 오른쪽 최고 높이) - 현재 칸 높이
        int water = min(maxLeft, maxRight) - v[i];
        if(water < 0) {
            water = 0;
        } else {
            res += water;
        }
    }
    cout << res;
}