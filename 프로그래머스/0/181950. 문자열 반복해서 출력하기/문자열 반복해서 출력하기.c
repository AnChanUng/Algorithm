#include <stdio.h>
#include <string.h>

#define LEN_INPUT 11

int main(void) {
    char s1[LEN_INPUT];
    int a;
    scanf("%s %d", s1, &a);
    
    for(int i=1; i<=a; i++) {
        printf(s1);
    }
    return 0;
}