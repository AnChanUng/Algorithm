#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s, int n) {
    string answer = "";
    
    for(int i=0; i<s.size(); i++) {
        char c = s[i];
        
        if(c >= 'a' && c <= 'z') {
            answer += (char)((c - 'a' + n) % 26 + 'a');
        } else if(c >= 'A' && c <= 'Z') {
            answer += (char)((c - 'A' + n) % 26 + 'A');
        } else {
            answer += c;
        }
    }
    
    return answer;
}