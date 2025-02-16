#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b) {
    char string_ab[10];
    char string_ba[10];
    
    sprintf(string_ab, "%d%d", a, b);
    sprintf(string_ba, "%d%d", b, a);
    
    int num_ab = atoi(string_ab);
    int num_ba = atoi(string_ba);
    if(num_ab > num_ba) {
        return num_ab;
    } else {
        return num_ba;
    }
}