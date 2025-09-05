### 자주쓰는 함수
```
#include <algorithm>
*max_element(priorities.begin(), priorities.end()); // 가장 큰 수
*min_element(priorities.begin(), priorities.end()); // 가장 작은 수
min(a[0], a[1]), min(a[0], a[1])
fill(arr[i], arr[i]+5, -1) // arr[0]부터 arr[4]까지 -1로 채움

#include <cmath>
sqrt(x) // 제곱근 
```
### 문자열
```
#include <string>
string s;
s.back()          // 마지막 문자 가져오기
s.pop_back()      // 마지막 문자 삭제
s.push_back(문자) // 마지막에 문자 추가
stoi("문자")      // string -> int
to_string(숫자)   // int -> string
s.substr(pos, len)// 부분 문자열
s.find("문자");   // 문자열 찾기

#include <cctype>
toupper(문자)  // 대문자로 변경
tolower(문자)  // 소문자로 변경
```

### 정렬
```
#include <algorithm>
sort(a.begin(), a.end()) // 오름차순
sort(a.begin(), a.end(), greater<int>()) // 내림차순

int compare(pair<int, int> a, pair<int, int> b) {
    if(a.Y == b.Y) return a.X < b.X;
    return a.Y < b.Y;
}
sort(a.begin(), a.end(), compare); // 두 번째 기준 정렬, 같으면 첫 번째 기준 정렬
```

### 스택/큐
```
#include <stack>
stack.top()
#include <queue>
queue<int> q;
queue<pair<int, int>> q;
q.front().first // pair 자료형의 첫 번째 값
q.front().second // pair 자료형의 두 번째 값
q.push(10) // 뒤에 삽입
q.front() // 맨 앞 요소 반환       
q.back() // 맨 뒤 요소 반환        
q.pop() // 맨 앞 요소 삭제         
q.empty() // 비었는지 확인       
q.size() // 크기 확인

priority_queue<int> pq // 우선순위 큐 자료구조
priority_queue<int, vector<int>, greater<int>> pq
pq.top() // 가장 큰 값
pq.push()
```

### 집합/해시
```
#include <set>
set<int> s;
s.insert(x)
s.erase(x) 
s.find(x)  // iterator 반환, 없으면 s.end()
s.count(x) // 존재 여부 (0 or 1)
s.size()
s.empty()

#include <unordered_set> // 해시 기반 set
#include <unordered_map> // dict
```

### 순열/조합
```
#include <algorithm>
next_permutation(v.begin(), v.end()) // 다음 순열 (없으면 false)
prev_permutation(v.begin(), v.end()) // 이전 순열
```

### 누적합
```
#include <numeric>
accmulate(v.begin(), v.end(), 0) // 벡터 합
```
