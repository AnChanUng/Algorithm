## SUBSTR vs SUBSTRB
![image](https://github.com/user-attachments/assets/939bd3c8-93bf-4b0b-8667-71a1dfaedbd3)

```
SUBSTR(string, start_position [, length])
```
- string: 원본 문자열
- start_position: 시작 위치 (1부터 시작)
- length: 추출할 길이 (선택 사항, 생략 시 문자열 끝까지 추출) 

```
SUBSTRB(string, start_position [, byte_length])
```
- string: 원본 문자열
- start_position: 시작 위치 (1부터 시작)
- byte_length: 추출할 바이트 수 (선택 사항, 생략 시 문자열 끝까지 추출)

![image](https://github.com/user-attachments/assets/06f7b8bd-ad2a-47cc-a378-72353521bfe9)

> 한글이 UTF-8에서 3바이트기에 SUBSTRB('안녕하세요', 2, 3) 하면 2바이트에서 시작해야하는데, <br>
> 녕은 4바이트에서 시작함으로 깨지는 현상 발생

➡ VARCHAR2 타입의 문자열을 다룰 땐 보통 SUBSTR을 사용 <br>
➡ 바이트 단위 처리가 필요한 경우는 SUBSTRB 사용
