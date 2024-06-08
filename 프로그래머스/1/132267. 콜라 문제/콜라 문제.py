def solution(a, b, n):
    answer = 0
    while n >= a: 
        units = (n//a) * b
        answer += units
        n = (units + n % a)
    
    return answer