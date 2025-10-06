#include <bits/stdc++.h>
using namespace std;
int a, b;
int cnt = 1;

int main() {
    cin >> a >> b;
    while(b!=a) {
        if(b < a) {
            cout << -1;
            return 0;
        }
        if(b % 2 == 0) { 
            b /= 2;
        } else if(b % 10 == 1) { 
            b /= 10;
        } else {
            cout << -1;
            return 0;
        }
        cnt++;
    }
    cout << cnt;
}