def solution(progresses, speeds):
    answer = []
    for i in range(len(progresses)):
        
        days = (100 - progresses[i] + speeds[i] - 1) // speeds[i]
        answer.append(days)

    stack = []
    score = answer[0]
    count = 1
    
    for i in range(1, len(answer)):
        if score >= answer[i]:
            count += 1
        else:
            stack.append(count)
            score = answer[i]
            count = 1
    
    stack.append(count)
    
    return stack
            
            
        