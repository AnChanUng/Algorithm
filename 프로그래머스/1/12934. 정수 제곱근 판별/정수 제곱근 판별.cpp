#include <string>
#include <vector>
#include <cmath>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    long long number = sqrt(n);
    
    if(number * number == n) {
        answer = (number+1) * (number+1);
    } else {
        answer = -1;
    }
    
    return answer;
}