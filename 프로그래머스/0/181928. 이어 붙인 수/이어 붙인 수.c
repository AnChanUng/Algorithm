#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int solution(int num_list[], size_t num_list_len) {
    int answer = 0;
    char odd[1000] = "";
    char even[1000] = "";
    for(int i=0; i<num_list_len; i++) {
        if(num_list[i] % 2 == 0) {
            char buffer[20];
            snprintf(buffer, sizeof(buffer), "%d", num_list[i]);
            strcat(even, buffer);
        } else {
            char buffer[20];
            snprintf(buffer, sizeof(buffer), "%d", num_list[i]);
            strcat(odd, buffer);
        }
    }
 
    answer = atoi(even) + atoi(odd);
    return answer;
}