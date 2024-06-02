def solution(num):
    cnt = 0
    while True:
        if num == 1:
            break
        elif num % 2 == 0:
            num = num // 2
            cnt += 1
        else:
            num = num * 3 + 1
            cnt += 1
        
        if num == 1:
            break
        
        if cnt >= 500:
            return -1
            break
            
    return cnt