#include <string>
#include <vector>

using namespace std;

int solution(int left, int right) {
    // 약수의 개수 구하기
    int answer = 0;
    for(int i=left; i<=right; i++) {
        int count = 0;
        for(int j=1; j<=i; j++) {
            if(i % j == 0) {
                count++;
            }
        }
        if(count % 2 == 0) {
            answer += i;
        } else {
            answer -= i;
        }
    }
    
    return answer;
}