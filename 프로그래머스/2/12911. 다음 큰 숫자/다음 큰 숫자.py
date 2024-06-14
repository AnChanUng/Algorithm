def solution(n):
    
    num = bin(n)[2:].count('1') #이진법 변환
    while True:
        if num == bin(n+1)[2:].count('1'):
            return (n+1)
        else:
            n += 1