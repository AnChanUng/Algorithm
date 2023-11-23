def solution(n):
    
    answer = []
    count = 0
    
    for i in str(n):
        answer.append(int(i))
    
    for j in answer:
        count = count + j
    
    return count