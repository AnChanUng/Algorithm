def solution(n):
    
    answer = []
    answer1 = []
    
    for i in str(n):
        answer.append(i)
    
    answer.sort(reverse=True) 
    # ['8', '7', '3', '2', '1', '1']
    
    return int(''.join(answer))