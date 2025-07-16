#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool solution(int x) {
    bool answer = true;
    int number = 0;
    string str = to_string(x);
    
    for(int i=0; i<str.size(); i++) {
        number += str[i] - '0';
    }

    if(x % number == 0) {
        answer = true;
    } else {
        answer = false;
    }
    return answer;
}