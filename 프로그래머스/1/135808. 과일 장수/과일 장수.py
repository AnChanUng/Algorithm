def solution(k, m, score):
    answer = 0
    array = []
    #사과상자 가격 = 낮은점수(p) x 사과의개수(m)
    score.sort(reverse=True)
    for i in range(0, len(score), m):
        if len(score[i:i+m]) == m:
            answer += min(score[i:i+m]) * m
        else:
            break
    
    return answer
    