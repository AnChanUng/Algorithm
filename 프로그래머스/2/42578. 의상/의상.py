def solution(clothes):
    
    clo = dict()
    for name, kind in clothes:
        if kind in clo:
            clo[kind] += 1
        else:
            clo[kind] = 1
    
    count = 1
    for i in clo.values():
        count *= i + 1
    
    return count - 1
    
    
    