#include <bits/stdc++.h>
using namespace std;
int n;
vector<string> used;

bool isUsed(char c) {
    string ch(1, tolower(c));
    return find(used.begin(), used.end(), ch) != used.end();
}

int main() {
    cin >> n;
    cin.ignore();
    
    for(int i=0; i<n; i++) {
        string s;
        getline(cin, s);

        bool found = false;
        for(int j=0; j<s.size(); j++) {
            if((j == 0 || s[j-1] == ' ') && isUsed(s[j]) == false) {
                string ch(1, tolower(s[j]));
                used.push_back(ch);
                s.insert(j, "[");
                s.insert(j+2, "]");
                found = true;
                break;
            }
        }
        if(found == false) {
            for(int j=0; j<s.size(); j++) {
                if(s[j] != ' ' && isUsed(s[j]) == false) {
                    string ch(1, tolower(s[j]));
                    used.push_back(ch);
                    s.insert(j, "[");
                    s.insert(j+2, "]");
                    found = true;
                    break;
                }
            }
        }
        cout << s << "\n";
    }
}