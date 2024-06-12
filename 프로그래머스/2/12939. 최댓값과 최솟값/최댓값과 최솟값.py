def solution(s):
    answer = ''
    array = []
    s = s.split(" ")
    for i in s:
        array.append(int(i))
    
    min_number = str(min(array))
    answer += ''.join(min_number + " ")
    max_number = str(max(array))
    answer += ''.join(max_number)
    
    return answer
    