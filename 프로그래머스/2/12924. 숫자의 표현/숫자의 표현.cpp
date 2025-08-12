#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n) {
    int cnt = 0;
    for(int i=1; i<=n; i++) {
        int answer = i;
        if(answer == n) {
            cnt++;
            break;
        }
        for(int j=i+1; j<=n; j++) {
            answer += j;
            
            if(answer == n) {
                cnt++;
                break;
            }
            if(answer > n) {
                break;
            }
        }
    }
    
    return cnt;
}