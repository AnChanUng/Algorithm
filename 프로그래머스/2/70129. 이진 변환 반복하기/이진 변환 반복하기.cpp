#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int countIteration = 0;
    int countZero = 0;
    
    while(s != "1") {
        int len = s.length();
        int cnt = 0;
        for(int i=0; i<len; i++) {
            if(s[i] == '0') {
                cnt++;
            }
        }
        countZero += cnt;
        len -= cnt;
        s = "";
        while(len > 0) 
        {
            if(len % 2 == 1) {
                s += "1";
                cout << s << endl;
            } else {
                s += "0";
            }
            len /= 2;
        }
        countIteration++;
    }
    answer.push_back(countIteration);
    answer.push_back(countZero);
    
    return answer;
}