def solution(k, tangerine):
    answer = 0
    dict = {}
    tangerine.sort()
    
    for i in tangerine:
        if i in dict:
            dict[i] += 1
        else:
            dict[i] = 1
    
    d = sorted(dict.items(), key = lambda x: x[1], reverse=True)
    
    for i in d:
        k = k - i[1]
        answer += 1
        if (k <= 0):
            break
            
    return answer