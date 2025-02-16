#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* myString, const char* pat) {
    int answer = 0;
    char* num = malloc(strlen(myString));
    
    for(int i=0; i<strlen(myString); i++) {
        if(myString[i] == 'A') {
            num[i] = 'B';
        } else {
            num[i] = 'A';
        }
    }
    if(strstr(num, pat)) {
        answer = 1;
    } else {
        answer = 0;
    }
    
    return answer;
}