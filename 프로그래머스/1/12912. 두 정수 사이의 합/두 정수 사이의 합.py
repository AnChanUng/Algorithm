def solution(a, b):
    
    count = 0
    
    if a <= b:
        for i in range(a, b+1):
            count += i
    elif a > b:
        for i in range(b, a+1):
            count += i
        
    return count