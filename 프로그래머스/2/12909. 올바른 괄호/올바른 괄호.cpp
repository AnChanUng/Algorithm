#include<string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{
    bool answer = true;

    stack<int> stack;
    
    for(int i=0; i<s.size(); i++) {
        // '('면 추가 // ')'면 pop  
        if(s[i] == '(') {
            stack.push('(');
        } else if(s[i] == ')' && stack.size() > 0) {
            stack.pop();
        } else {
            return false;
        }
    }
    
    if(stack.size() == 0) {
        answer = true;
    } else {
        answer = false;
    }

    return answer;
}