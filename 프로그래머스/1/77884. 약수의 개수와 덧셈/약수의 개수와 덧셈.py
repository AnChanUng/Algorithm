def solution(left, right):
    answer = 0 # 전체합
    
    for i in range(left, right+1):
        result = 0 # 약수의 개수
        
        for j in range(1, i+1):
            if i % j == 0:
                result += 1 # 약수의 개수
        
        if result % 2 == 0:
            answer += i
        else:
            answer -= i
       
    return answer