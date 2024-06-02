def solution(left, right):
    total = 0
    for num in range(left, right+1):
        cnt = 0
        for i in range(1, num+1):
            if num % i == 0:
                cnt += 1
        
        if cnt % 2 == 0:
            total += num
        else:
            total -= num
    
    return total