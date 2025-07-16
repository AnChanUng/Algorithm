#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    int p_count = 0;
    int y_count = 0;
    for(int i=0; i<s.size(); i++) {
        if(s[i] == 'p' or s[i] == 'P') {
            p_count += 1;
        } else if(s[i] == 'y' or s[i] == 'Y') {
            y_count += 1;
        }
    }
    
    if(p_count == y_count) {
        answer = true;
    } else {
        answer = false;
    }

    return answer;
}