#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string t, string p) {
    int count = 0;
    
    for(int i=0; i<t.size()-p.size()+1; i++) {
        string sub = t.substr(i, p.size());

        long long number1 = stoll(sub);
        long long number2 = stoll(p);
        
        if(number1 <= number2) {
            count++;
        }
    }
    
    return count;
}