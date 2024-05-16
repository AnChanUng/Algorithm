def solution(n, lost, reserve):
    
    count = [1] * n
    
    for a in range(len(lost)):
        count[lost[a]-1] -= 1
    
    for b in range(len(reserve)):
        count[reserve[b]-1] += 1
    
    for i in range(n):
        if count[i] == 0:
            if i > 0 and count[i-1] == 2:
                count[i] = 1
                count[i-1] = 1
            elif i < n - 1 and count[i+1] == 2:
                count[i] = 1
                count[i+1] = 1
    
    for num in range(len(count)):
        if count[num] >= 2:
            count[num] = 1
    
    return sum(count)