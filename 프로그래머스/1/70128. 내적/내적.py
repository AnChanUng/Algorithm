def solution(a, b):

    result = 0
    
    # zip(a,b)는 두 리스트 a와 b를 인덱스의 요소들끼리 묶어주는 역할
    # 즉 a의 첫 번째 요소와 b의 첫번쨰 요소가, a의 두번째 요소와 b의 두번째 요소가 순서대로 묶입니다.
    for x, y in zip(a,b):
        result += x*y
    
    return result