#include <string>
#include <vector>
#include <iostream>
using namespace std;

string toBinary(int n) {
    string str = "";
    int cnt = 0;
    while(n > 0) {
        if(n % 2 == 0) {
            str += '1';
            cnt++;
        } else {
            str += '0';
        }
        n /= 2;
    }
    return str;
}

int solution(int n) {
    int answer = 0;
    
    while(true) {
        n++;
        toBinary(n);
        if(number == answer) {
            break;
        }
    }
    
    return answer;
}