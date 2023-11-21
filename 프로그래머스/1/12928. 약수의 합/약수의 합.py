def solution(n):
    
    yak_su = []
    cnt = 0
    
    for i in range(1, n+1):
        if n % i == 0:
            yak_su.append(i)
    
    for j in range(len(yak_su)):
        cnt += yak_su[j]
    
    return cnt