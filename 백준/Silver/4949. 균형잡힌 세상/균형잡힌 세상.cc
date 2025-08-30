#include <string>
#include <stack>
#include <iostream>
using namespace std;
int cnt = 0;
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    while(true) {
        string s;
        cnt++;
        getline(cin, s);
        if(s == ".") break;
        stack<char> st;
        bool valid = true;
        
        for(int i=0; i<s.size(); i++) {
            if(s[i] == '(' || s[i] == '[') {
                st.push(s[i]);
            } else if(s[i] == ')') {
                if(st.empty() || st.top() != '(') {
                    valid = false;
                    break;
                }
                st.pop();
            } else if (s[i] == ']') {
                if(st.empty() || st.top() != '[') {
                    valid = false;
                    break;
                }
                st.pop();
            }
        }
        if(!st.empty()) {
            valid = false;
        }
        if(valid == true) {
            cout << "yes" << "\n";
        } else {
            cout << "no" << "\n";
        }
    }
}