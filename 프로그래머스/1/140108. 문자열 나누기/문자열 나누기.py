def solution(s):
    answer = 0
    count = [0, 0]
    for i in s:
        if count[0] == count[1]:
            answer += 1
            k = i
        
        if k == i:
            count[0] += 1
        else:
            count[1] += 1
    
    return answer