#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    
    int tmp1 = 2 * a * b;
    string str = to_string(a) + to_string(b);
    int tmp2 = stoi(str);
    
    if(tmp1 < tmp2) {
        answer = tmp2;
    } else {
        answer = tmp1;
    }
    
    return answer;
}