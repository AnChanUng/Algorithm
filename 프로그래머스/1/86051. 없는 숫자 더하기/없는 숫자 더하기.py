def solution(numbers):
    
    count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    
    for i in range(len(numbers)):
        count[numbers[i]] += 1
    
    result = 0
    for j in range(len(count)):
        if count[j] == 0:
            result += j
    
    return result