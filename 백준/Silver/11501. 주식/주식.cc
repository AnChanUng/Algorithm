#include <bits/stdc++.h>
using namespace std;
int t, day;
int main() {
    cin >> t;
    for(int i=0; i<t; i++) {
        cin >> day;
        vector<int> jusik(day);
        for(int j=0; j<day; j++) {
            cin >> jusik[j];
        }
        long long result = 0;
        int maxPrice = 0;
        for(int j=day-1; j>=0; j--) {
            if(jusik[j] > maxPrice) {
                maxPrice = jusik[j];
            } else {
                result += (maxPrice - jusik[j]);
            }
        }
        cout << result << "\n";
    }
}