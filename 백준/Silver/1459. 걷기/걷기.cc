#include <bits/stdc++.h>
using namespace std;
long long x, y, w, s;
long long result = 0; 
int main() {
    cin >> x >> y >> w >> s;   
    
    if(w * 2 < s) {
        result = (x + y) * w;
    } else if (s > w) {
        result = min(x, y) * s + (max(x, y) - min(x, y)) * w;
    } else {
        if((x+y) % 2 == 0) {
            result = max(x, y) * s;
        } else {
            result = (max(x, y)-1) * s + w;
        }
    }

    cout << result;
}