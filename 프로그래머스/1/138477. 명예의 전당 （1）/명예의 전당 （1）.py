def solution(k, score):
    answer = []
    result = []
    for i in range(len(score)):
        if len(answer) < k:
            answer.append(score[i])
            result.append(min(answer))
        else:
            if min(answer) < score[i]:
                answer.append(score[i])
                answer.remove(min(answer))
                result.append(min(answer))
            else:
                result.append(min(answer))
    
    return result