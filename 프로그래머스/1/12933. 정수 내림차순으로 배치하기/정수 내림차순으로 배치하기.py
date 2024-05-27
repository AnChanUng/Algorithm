def solution(n):
    
    array = []
    for i in str(n):
        array.append(int(i))
    
    array.sort(reverse=True)
    
    result = ""
    for i in array:
        result += str(i)
    
    return int(''.join(result))