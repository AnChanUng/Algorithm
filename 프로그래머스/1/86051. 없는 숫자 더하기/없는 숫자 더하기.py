def solution(numbers):
    cnt = 0
    number = set([0,1,2,3,4,5,6,7,8,9])
    
    notfind = number - set(numbers)
    
    for i in notfind:
        cnt += i
    
    return cnt