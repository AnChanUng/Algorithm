#include <bits/stdc++.h>
using namespace std;
string s;
int main() {
    cin >> s;
    int cntzero = 0;
    int cntone = 0;
    // s의 0과 1의 개수를 센다
    for(int i=0; i<s.size(); i++) {
        if(s[i] == '0') {
            cntzero++;
        } else {
            cntone++;
        }
    }
    
    // 절반의 개수를 지운다
    cntzero = cntzero / 2;
    cntone = cntone / 2;
    
    string result = "";
    for(int i=0; i<cntzero; i++) {
        result += '0';
    }

    for(int i=0; i<cntone; i++) {
        result += '1';
    }

    cout << result;
}