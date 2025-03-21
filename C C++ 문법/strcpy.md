## strcpy()
```
#include <string.h>

char *strcpy(char *dest, const char *src);
```
- src 문자열을 dest 문자열에 복사하는 함수
- 복사된 문자열 끝에는 자동으로 널문자('\0')가 추가

⚠️ 주의사항
- dest의 공간이 src보다 반드시 커야 합니다.

## strcnpy()
```
strncpy(dest, src, sizeof(dest) - 1);
dest[sizeof(dest) - 1] = '\0'; // 널문자 명시적 추가
```
> 문자열의 길이를 모르거나 버퍼 크기를 확신 할 수 없을 때, strncpy() 사용 권장
