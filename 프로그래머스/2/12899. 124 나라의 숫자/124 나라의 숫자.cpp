#include <bits/stdc++.h>
using namespace std;

string solution(int n) {
    string answer = "";
    string nums[3] = {"4", "1", "2"};
    
    while(n > 0) {
        int r = n % 3;
        answer += nums[r];
        if(r == 0) {
            n = n/3 - 1;
        } else {
            n /= 3;
        }
    }
    reverse(answer.begin(), answer.end());
    return answer;
}