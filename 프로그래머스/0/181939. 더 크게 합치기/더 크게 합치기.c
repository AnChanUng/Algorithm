#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b) {
    
    char num1[9];
    char num2[9];
    
    snprintf(num1, 9, "%d%d\0", a, b);
    snprintf(num2, 9, "%d%d\0", b, a);
    
    if (atoi(num1) >= atoi(num2)) {
        return atoi(num1);
    } else {
        return atoi(num2);
    }
}