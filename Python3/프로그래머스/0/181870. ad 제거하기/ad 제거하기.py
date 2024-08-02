def solution(strArr):
    
    numbers = []
    for i in strArr:
        if 'ad' in i:
            numbers.append(i)
    
    for i in numbers:
        if i in strArr:
            strArr.remove(i)
            
    return strArr