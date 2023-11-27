def solution(s):
    
    middle = len(s) // 2
    
    if len(s) % 2 == 0:
        return s[middle-1: middle+1]
    else:
        return s[middle]