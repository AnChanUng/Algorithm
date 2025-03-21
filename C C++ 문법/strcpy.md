## strcpy()
```
#include <string.h>

char *strcpy(char *dest, const char *src);
```
- src 문자열을 dest 문자열에 복사하는 함수
- 복사된 문자열 끝에는 자동으로 널문자('\0')가 추가

> dest의 공간이 src보다 반드시 커야 합니다.

## strcnpy()
```
strncpy(dest, src, sizeof(dest) - 1);
dest[sizeof(dest) - 1] = '\0'; // 널문자 명시적 추가
```
> 문자열의 길이를 모르거나 버퍼 크기를 확신 할 수 없을 때, strncpy() 사용 권장

## strcmp()
```
int strcmp(const char *str1, const char *str2);
```
- 두 개의 문자열(str1, str2)을 비교하는 함수
- 반환값
  - 0	| 두 문자열이 완벽히 같음
  - 음수 | str1이 str2보다 작음 (사전순으로 앞)
  - 양수 | str1이 str2보다 큼 (사전순으로 뒤)
  - 정확히는 첫 번째로 다른 문자의 ASCII 코드 값을 뺀 결과를 반환

