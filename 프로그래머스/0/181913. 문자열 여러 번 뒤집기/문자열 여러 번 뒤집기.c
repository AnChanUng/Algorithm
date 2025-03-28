#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// queries_rows는 2차원 배열 queries의 행 길이, queries_cols는 2차원 배열 queries의 열 길이입니다.
// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, int** queries, size_t queries_rows, size_t queries_cols) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    char* answer = (char*)malloc(strlen(my_string)+1);
    
    strcpy(answer, my_string);
    
    for(size_t i=0; i<queries_rows; i++) {
        int s = queries[i][0];
        int e = queries[i][1];
        
        while(s < e) {
            char temp = answer[s];
            answer[s] = answer[e];
            answer[e] = temp;
            s++;
            e--;
        }
    }
    
    return answer;
}