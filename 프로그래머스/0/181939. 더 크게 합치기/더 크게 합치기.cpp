#include <string>
#include <vector>

using namespace std;

int solution(int a, int b) {
    int answer = 0;
    
    int tmp1 = 0;
    int tmp2 = 0;
    
    string str = "";
    
    str = to_string(a) + to_string(b);
    tmp1 = stoi(str);
    str = to_string(b) + to_string(a);
    tmp2 = stoi(str);
    
    if(tmp1 > tmp2) {
        answer = tmp1;
    } else if(tmp1 < tmp2) {
        answer = tmp2;
    } else {
        answer = tmp2;
    }
    
    return answer;
}