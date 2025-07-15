```
char *strptime(const char *s, const char *format, struct tm *tm);
```

s: 변환하고 싶은 날짜/시간 문자열 
> 예: "2024-07-15-16-00-00"

format: 입력 문자열의 포맷
> 예: "%Y-%m-%d-%H-%M-%S"

tm: 결과를 저장할 struct tm 포인터
> 여기에 변환된 날짜/시간 정보가 채워짐

### struct tm 구조체
```
struct tm {
    int tm_sec;   // 초 (0-60)
    int tm_min;   // 분 (0-59)
    int tm_hour;  // 시 (0-23)
    int tm_mday;  // 일 (1-31)
    int tm_mon;   // 월 (0-11, 0=1월)
    int tm_year;  // 년 (1900부터의 년수, 예: 2024년이면 124)
};
```
