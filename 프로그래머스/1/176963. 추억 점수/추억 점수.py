def solution(name, yearning, photo):
    answer = []
    for i in range(len(photo)):
        result = 0
        for j in range(len(photo[i])):
            if photo[i][j] in name:
                result += yearning[name.index(photo[i][j])]
        
        answer.append(result)
    
    return answer