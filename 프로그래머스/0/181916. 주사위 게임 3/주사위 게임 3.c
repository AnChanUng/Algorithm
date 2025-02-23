#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b, int c, int d) {
    int dice[4] = {a, b, c, d};
    
    int count[7] = {0};
    
    for(int i=0; i<4; i++) {
        count[dice[i]]++;
    }
    
    if(count[a] == 4) {
        return 1111 * a;
    }
    
    for(int i=1; i<=6; i++) {
        if(count[i] == 3) {
            for(int j=1; j<=6; j++) {
                if(count[j] == 1) {
                    return (10*i+j) * (10*i+j);
                }
            }
        }
    }
    
    for(int i=1; i<=6; i++) {
        for(int j=i+1; j<=6; j++) {
            if(count[i] == 2 && count[j] == 2) {
                return (i+j) * abs(i-j);
            }
        }
    }
    
    for(int i=1; i<=6; i++) {
        if(count[i] == 2) {
            for(int j=1; j<=6; j++) {
                if(count[j] == 1) {
                    for(int k=j+1; k<=6; k++) {
                        if(count[k] == 1) {
                            return j * k;
                        }
                    }
                }
            }
        }
    }
    
    int min_val = 7;
    for(int i=0; i<4; i++) {
        if(dice[i] < min_val) {
            min_val = dice[i];
        }
    }
    return min_val;
}