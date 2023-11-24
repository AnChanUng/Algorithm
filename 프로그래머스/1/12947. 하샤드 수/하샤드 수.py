def solution(x):
    
    answer = []
    count = 0
    
    for i in str(x):
        answer.append(i)
    
    for j in range(len(answer)):
        count += int(answer[j])
         
    if x % count == 0:
        return True
    return False