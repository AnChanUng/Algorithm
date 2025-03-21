## getenv()
```
#include <stdlib.h>

char *getenv(const char *name);
```
- 시스템에서 정의된 환경변수의 값을 가져오는 함수
- 주어진 환경변수 이름(name)과 일치하는 환경변수 값을 문자열로 반환

⚠️ 주의사항
- 환경변수가 존재하지 않을 경우 NULL을 반환합니다.
- 반환된 문자열은 수정하면 안 됩니다.
