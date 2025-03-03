#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
int* solution(int arr[], size_t arr_len) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* stk = (int*)malloc(sizeof(int) * arr_len);
    int cnt = 0;
    for(int i=0; i<arr_len; i++) {
        if(!cnt) {
            stk[cnt] = arr[i];
            cnt++;
        } else {
            if(stk[cnt-1] < arr[i]) {
                stk[cnt] = arr[i];
                cnt++;
            } else {
                *(stk+cnt-1) = NULL;
                i--;
                cnt--;
            }
        }
    }
    
    return stk;
}