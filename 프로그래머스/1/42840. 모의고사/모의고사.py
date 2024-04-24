def solution(answers):
    
    number1 = [1, 2, 3, 4, 5]
    number2 = [2, 1, 2, 3, 2, 4, 2, 5]
    number3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    count1, count2, count3 = 0, 0, 0
    
    for i in range(len(answers)):
        if number1[i%5] == answers[i]:
            count1 += 1
        if number2[i%8] == answers[i]:
            count2 += 1
        if number3[i%10] == answers[i]:
            count3 += 1
    
    k = max(count1, count2, count3)
    answer = []
    
    if k == count1:
        answer.append(1)
    if k == count2:
        answer.append(2)
    if k == count3:
        answer.append(3)
    
    return answer