#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n) {
    int* answer = (int*)malloc(index);
    
    int index = 0;
    while(n != 1) {
        answer[index++] = n;
        if(n%2==0) {
            n = n / 2;
        } else {
            n = n * 3 + 1;
        }
    }
    answer[index++] = 1;
    return answer;
}