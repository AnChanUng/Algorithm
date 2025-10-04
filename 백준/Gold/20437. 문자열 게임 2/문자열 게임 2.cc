#include <bits/stdc++.h>
using namespace std;
int t, k;
string w;
int main() {
    cin >> t;
    for(int test=0; test<t; test++) {
        cin >> w;
        cin >> k;

        int minNum = INT_MAX;
        int maxNum = -1;

        for(char c='a'; c<='z'; c++) {
            vector<int> pos;
            for(int i=0; i<w.size(); i++) {
                if(w[i] == c) {
                    pos.push_back(i);
                }
            }
            if(pos.size() < k) continue;

            for(int i=0; i<=pos.size()-k; i++) {
                int start = pos[i];
                int end = pos[i+k-1];
                int len = end - start + 1;
                minNum = min(minNum, len);
                maxNum = max(maxNum, len);
            }
        }
        if(maxNum == -1) cout << -1 << "\n";
        else cout << minNum << " " << maxNum << "\n";
    }
}