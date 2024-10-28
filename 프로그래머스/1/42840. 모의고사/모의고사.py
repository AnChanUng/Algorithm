def solution(answers):
    number1 = [1, 2, 3, 4, 5]
    number2 = [2, 1, 2, 3, 2, 4, 2, 5]
    number3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    cnt1 = cnt2 = cnt3 = 0
    for i in range(len(answers)):
        if answers[i] == number1[i%len(number1)]:
            cnt1 += 1
        
        if answers[i] == number2[i%len(number2)]:
            cnt2 += 1
        
        if answers[i] == number3[i%len(number3)]:
            cnt3 += 1
    
    count = [cnt1, cnt2, cnt3]
    
    array = []
    for i in range(len(count)):
        if count[i] == max(count):
            array.append(i+1)
    
    return array