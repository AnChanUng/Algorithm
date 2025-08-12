#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

string toBinary(int n, int &cnt) {
    string str = "";
    cnt = 0;
    while(n > 0) {
        if(n % 2 == 1) {
            str += '1';
            cnt++;
        } else {
            str += '0';
        }
        n /= 2;
    }
    reverse(str.begin(), str.end());
    return str;
}

int solution(int n) {
    int targetcnt = 0;
    toBinary(n, targetcnt);
    
    int x = n + 1;
    while(true) {
        int ones = 0;
        toBinary(x, ones);
        if(ones == targetcnt) {
            return x;
        }
        x++;
    }
}