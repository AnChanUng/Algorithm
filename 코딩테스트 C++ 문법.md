### 자주쓰는 함수
```
#include <algorithm>
*max_element(priorities.begin(), priorities.end()); // 가장 큰 수
```
### 문자열
```
#include <string>
back() // 마지막 문자 가져오기
pop_back() // 마지막 문자 삭제
push_back(문자) // 마지막에 문자 추가

#include <cctype>
toupper(문자) // 대문자로 변경
tolower(문자) // 소문자로 변경
```

### 정렬
```
#include <algorithm>
sort(A.begin(), A.end()) // 오름차순
sort(A.begin(), A.end(), greater<int>()) // 내림차순
```

### 스택/큐
```
#include <stack>

#include <queue>
queue<int> q;
queue<pair<int, int>> q;
q.front().first // pair 자료형의 첫 번째 값
q.front().second // pair 자료형의 두번째 값
q.push(10) // 뒤에 삽입
q.front() // 맨 앞 요소 반환       
q.back() // 맨 뒤 요소 반환        
q.pop() // 맨 앞 요소 삭제         
q.empty() // 비었는지 확인       
q.size() // 크기 확인

priority_queue<int> mx // 우선순위 큐 자료구조
mx.top() // 가장 큰 값
```

### 해시
```
#include <unordered_map> // dict
#include <unordered_set> // set

insert({k, v}) 
erase(key)
find(key)  // 키 iterator 반환 없으면 end()
count(key) // 해당 key 개수 반환
size()
empty()
```
