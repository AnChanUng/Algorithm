#include <bits/stdc++.h>
using namespace std;

int solution(int n, int a, int b)
{
    int answer = 1;
        
    while(true) {
        if(abs(a-b) == 1 && max(a, b) % 2 == 0) break;
        a = (a+1) / 2;
        b = (b+1) / 2;
        answer++;
        //cout << "a: " << a << " b: " << b << "\n";
    }
    
    return answer;
}