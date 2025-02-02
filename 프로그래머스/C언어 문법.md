## 기초 출력
```
Hello, World !!!
#include <stdio.h>

int main () {
	printf("Hello, World !!!");
	return 0;
}
```
- #include <stdio.h> => 표준 입출력 라이브러리, 'stdio.h'를 포함한다.
- int main() {} => 반환값이 없는 main 함수를 선언한다.
- printf("Hello, World !!!"); => 'Hello, World'를 콘솔에 출력한다.
- return 0; => main함수를 마친다.

## 변수 선언, 입출력
```
#include <stdio.h>

int main () {
	int Value_1 = 0;
	char Value_2 = 'A';
	float Value_3 = 3.14;
	
	scanf("%d", &Value_1);
	printf("정수:%d, 문자:%c, 소수:%f", Value_1, Value_2, Value_3);

	return 0;
}
```
- scanf("%d", $Value_1); => 콘솔에서 정수형을 입력받아 Value_1 변수에 저장한다.

## 함수 선언
```
#include <stdio.h>

// 반환값과 인수가 없는 함수.
void print_hello () {
	printf("hello");
}

// 반환값이 int고 정수형 인수가 두 개인 함수.
int get_sum (int a, int b) {
	return a+b;
}

int main () {
	print_hello(); // print_hello 함수 호출
	printf("10 + 5 = %d", get_sum(10, 5)); // get_sum에 매개변수로 10과 5를 넣어 호출.
}
```

### for문
```
#include <stdio.h>

int main () {
	for (int i = 0; i < 5; i++) {
		printf("%d ", i);
	}
	return 0;
}
```

### while문
```
#include <stdio.h>

int main () {
	int i = 0;
	while (i < 5) {
		printf("%d ", i);
		i++;
	}
	return 0;
}
```
- while (i < 5)=> i가 5보다 작은 동안 반복하는 while문 선언.
- printf("%d ", i);=> 반복되는 동안 현재의 i 값을 출력.
- i++;=> i 값을 증가시킴.

### if, else 문
```
#include <stdio.h>

int main () {
	int num = 10;
	if (num > 0) {
		printf("양수입니다.");
	}
	else if (num < 0) {
		printf("음수입니다.");
	}
	else {
		printf("0입니다.");
	}
	return 0;
}
```
- if (num > 0)=> num이 양수인지 확인하는 if문 선언.
- else if (num < 0)=> num이 음수인지 확인하는 else if문 선언.
- else=> 위의 조건들이 모두 아닐 때 실행되는 else문 선언.

### switch, case문
```
#include <stdio.h>

int main () {
	char grade = 'B';
	switch (grade) {
		case 'A':
			printf("우수한 학점입니다.");
			break;
		case 'B':
			printf("보통 학점입니다.");
			break;
		case 'C':
			printf("미흡한 학점입니다.");
			break;
		default:
			printf("유효하지 않은 학점입니다.");
	}
	return 0;
}
```
- switch (grade)=> 변수 grade의 값에 따라 분기하는 switch문 선언.
- case 'A':, case 'B':, case 'C':=> grade의 값에 따라 다른 메시지 출력.
- default:=> 위의 case들에 해당하지 않는 경우 실행되는 default문 선언.

### 연산자
```
#include <stdio.h>

int main() {
	int a = 5, b = 2;
	printf("덧셈: %d\n", a + b);
	printf("뺄셈: %d\n", a - b);
	printf("곱셈: %d\n", a * b);
	printf("나눗셈: %d\n", a / b);
	return 0;
}
```
### 비트연산자
```
#include <stdio.h>

int main() {
	int a = 5, b = 3;
	printf("AND 연산: %d\n", a & b);
	printf("OR 연산: %d\n", a | b);
	printf("XOR 연산: %d\n", a ^ b);
	printf("비트 NOT 연산: %d\n", ~a);
	return 0;
}
```

### 삼항 연산자
```
#include <stdio.h>

int main() {
	int a = 5, b = 10;
	int max = (a > b) ? a : b;
	printf("최댓값: %d\n", max);
	return 0;
}
```

### 기초 자료형
```
#include <stdio.h>

int main() {
	int integerVar = 10;
	long long int longIntegerVar = 100;
	char charVar = 'A';
	float floatVar = 3.14;
	double doubleVar = 3.1415;
	return 0;
}
```

### 배열
```
#include <stdio.h>

int main() {
    // 일차원 배열
    int intArray[5] = {1, 2, 3, 4, 5};
    for (int i = 0; i < 5; ++i) {
	    printf("%d", intArray[i]);
    }
    // 이차원 배열
    int matrix[2][3] = {{1, 2, 3}, {4, 5, 6}};
	for (int i = 0; i < 2; ++i) {
		for (int j = 0; j < 3; ++j) {
			printf("%d", matrix[i][j]);
		}
    }
    return 0;
}
```
- int intArray[5] = {1, 2, 3, 4, 5}; => 크기가 5인 정수형 일차원 배열 선언 및 초기화.
- int matrix[2][3] = {{1, 2, 3}, {4, 5, 6}} => 크기가 2X3인 정수형 이차원 배열 선언 및 초기화.

### 문자열
```
#include <stdio.h>
#include <string.h>

int main() {
    char str1[] = "Hello";
    char str2[10];
    
    strcpy(str2, str1); // 문자열 복사
    strcat(str2, " World"); // 문자열 연결
    
    printf("String 1: %s\n", str1);
    printf("String 2: %s\n", str2);
    
    return 0;
}
```
- #include <string.h> => 문자열 라이브러리

### 지역변수, 전역변수
```
#include <stdio.h>

int globalVar = 20; // 전역 변수
int main() {
	int localVar = 30; // 지역 변수
	return 0;
}
```
- int globalVar = 20;=> 전역 변수 선언.
- int localVar = 30;=> 지역 변수 선언.

### 심화 자료형
```
#include <stdio.h>

struct Point {
	int x;
	int y;
};

enum Hand {
	Rock,
	Scissors,
	Paper
};

int main() { 
	struct Point p;
	p.x = 10;
	p.y = 20; 
	printf("Point: (%d, %d) \n", p.x, p.y);

	enum Hand My_hand = Scissors;
	switch (My_hand) {
		case Rock: 
			printf("Rock\n"); 
			break; 
		case 1: 
			printf("Scissors\n"); 
			break; 
		case 2: 
			printf("Paper\n"); 
			break; 
	}

    return 0;
}
```
- struct Point { int x; int y; }; => 구조체 선언. ( 자료형 교차선택 가능. )
- enum Hand { Rock, Scissors, Paper }; => 열거체 선언. ( 첫 항목부터 0, 1, 2 할당. )
- 구조체, 열거체 선언 후에는 변수처럼 생성 가능.

### 동적할당
```
#include <stdio.h>
#include <stdlib.h>

int main() {
	int *dynamicVar;
	dynamicVar = (int *)malloc(sizeof(int));
	if (dynamicVar == NULL) {
		printf("메모리 할당 실패");
		return 1;
	}
	*dynamicVar = 40;
	printf("동적으로 할당된 변수 값: %d", *dynamicVar);
	free(dynamicVar);
	
	int *dynamicArr;
	dynamicArr = (int *)malloc(5 * sizeof(int));
	for (int i = 0; i < 5; i++) { dynamicArr[i] = i + 1; }
	for (int i = 0; i < 5; i++) { printf("%d ", dynamicArr[i]); }
	free(dynamicArr);
	
	return 0;
}
```
- int *dynamicVar;=> 정수형 포인터 변수 선언.
- dynamicVar = (int *)malloc(sizeof(int));=> 동적으로 메모리 할당.
- *dynamicVar = 40;=> 할당된 메모리에 값 할당.
- free(dynamicVar);=> 동적으로 할당된 메모리 해제.
- dynamicArr = (int *)malloc(5 * sizeof(int)); => 길이가 5인 배열 동적 할당.

## 포인터
```
#include <stdio.h>

int add(int a, int b) {
	return a+b;
}

int main() {
	int var = 50;
	int *ptr;
	ptr = &var;
	printf("변수의 값: %d\n", var);
	printf("포인터를 통한 변수의 값: %d", *ptr);

	int arr[] = {1, 2, 3, 4, 5};
	int *ptr = arr;
	for (int i = 0; i < 5; i++) { 
		printf("%d ", *ptr); 
		ptr++; 
	}

	int (*operation)(int a, int b);
	operation = add;
	print("%d", operation(5, 10))
	
	return 0;
}
```
- int var = 50;=> 정수형 변수 선언.
- int *ptr;=> 정수형 포인터 변수 선언.
- ptr = &var;=> 포인터에 변수의 주소를 할당. > scanf에서 변수 앞에 &를 붙이는 이유, 타 함수에서 지역변수에 직접 접근 불가 -> 주소 전달
- *ptr=> 포인터를 통해 변수의 값에 접근.
- 배열의 포인터는 기본적으로 배열의 첫 요소를 저장함. 다음 인덱스의 주소는 이전 인덱스의 주소+1임.
int (*operation)(int a, int b); => 반환형이 int이고 정수형 변수 a와 b를 매개변수로 갖는 포인터 변수 'operation' 선언.
포인터에 sum함수의 주소를 할당.

## 파일 입출력
### 파일 쓰기
#include <stdio.h>
```
int main() {
    FILE *file;
    char data[] = "File I/O Example";

    file = fopen("example.txt", "w"); // write 모드로 열기
    
    if (file != NULL) {
        fprintf(file, "%s", data); // file에 문자열 형식으로 data 쓰기
        fclose(file);
        printf("Data written to file successfully.\n");
    } else {
        printf("Error opening file.\n");
    }

    return 0;
}
```

### 파일 읽기
```
#include <stdio.h>

int main() {
    FILE *file;
    char buffer[100]; // 읽은 데이터를 저장할 버퍼

    file = fopen("example.txt", "r"); // read 모드로 열기
    
    if (file != NULL) {
        // 파일에서 데이터 읽기
        while (fgets(buffer, sizeof(buffer), file) != NULL) {
            printf("%s", buffer);
        }
        fclose(file);
        printf("Data read from file successfully.\n");
    } else {
        printf("Error opening file.\n");
    }

    return 0;
}
```
