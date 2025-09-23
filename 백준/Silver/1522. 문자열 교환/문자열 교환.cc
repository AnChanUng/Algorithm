#include <bits/stdc++.h>
using namespace std;
int main() {
    string word;
    cin >> word;
    int n = word.size();
    int aCnt = 0;
    for(char c : word) {
        if(c == 'a') aCnt++;
    }
    if(aCnt == 0 || aCnt == n) {
        cout << 0 << "\n";
        return 0;
    }
    word += word;
    int bCnt = 0;
    for(int i=0; i<aCnt; i++) {
        if(word[i] == 'b') {
            bCnt++;
        }
    }
    int minBcnt = bCnt;
    for(int i=aCnt; i<word.size(); i++) {
        if(word[i-aCnt] == 'b') bCnt--;
        if(word[i] == 'b') bCnt++;
        minBcnt = min(minBcnt, bCnt);
    }
    cout << minBcnt << "\n";
}