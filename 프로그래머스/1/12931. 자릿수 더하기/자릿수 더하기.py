def solution(n):
    
    result = 0
    for i in range(len(str(n))):
        result += int(str(n)[i])
    return result