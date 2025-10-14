#include <bits/stdc++.h>
using namespace std;
long long a, b, c;

long long modPow(long long a, long long b, long long c) {
    if(b == 1) return a % c;
    long long val = modPow(a, b / 2, c);
    val = (val * val) % c;

    if(b % 2 == 0) return val;
    else return (val * a) % c;
}

int main() {
    cin >> a >> b >> c;
    cout << modPow(a, b, c);
}