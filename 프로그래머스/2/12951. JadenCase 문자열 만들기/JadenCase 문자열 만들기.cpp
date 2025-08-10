#include <string>
#include <vector>
#include <cctype>
using namespace std;

string solution(string s) {
    bool newWord = true;
    for(int i=0; i<s.size(); i++) {
        if(newWord) {
            s[i] = toupper(s[i]);
            newWord = false;
        } else {
            s[i] = tolower(s[i]);
        }
        if(s[i] == ' ') {
            newWord = true;
        }
    }
    
    return s;
}