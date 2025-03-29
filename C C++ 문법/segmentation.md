## Segmentation Fault
Unix 및 Linux, macOS 등 Unix 기반 시스템에서 발생하는 오류 <br>
프로그램이 메모리의 잘못된 영역에 접근하려 할 때 발생하는 오류 <br>
이 오류가 발생하면 운영체제는 프로그램을 강제 종료시키며, 이때 메모리 상태를 담은 "core dump" 파일을 생성할 수 있음

### 발생하는 상황
- NULL 포인터를 참조할 때
- 동적 할당하지 않은 메모리에 접근할 때
- 배열의 범위를 초과하여 접근할 때
- 메모리 누수로 인해 할당이 잘못된 경우
- 스택 오버플로우 (Stack Overflow)

### 예시
```
int *ptr = NULL;  // NULL 포인터
printf("%d", *ptr);  // Segmentation Fault 발생!
```

## Core Dump
- Segmentation Fault와 같은 오류 발생 시 프로그램이 비정상 종료되면서 남기는 메모리 상태 기록 파일
- 디버깅 목적으로 생성되며, 프로그램이 왜 비정상 종료되었는지 확인할 때 사용
- 주로 core라는 이름의 파일로 생성되며, 실행 파일과 같은 디렉터리에 위치
- 기본적으로는 생성되지 않을 수 있으며, 필요시 설정을 통해 활성화

### core dump 활성화 방법
```
ulimit -c unlimited # 코어 덤프 크기 제한 해제
```

즉, "Segmentation Fault (core dump)" 메시지는 프로그램이 메모리 접근 오류를 일으켜 강제 종료되었고, 그 과정에서 디버깅을 위한 코어 덤프 파일을 생성했다는 의미

