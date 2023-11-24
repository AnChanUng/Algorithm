def solution(n):
    
    #n의 제고급 (루트 씌우기)
    n = n ** (0.5)
    
    #n이 정수면 (n+1)**2 리턴
    if n % 1 == 0:
        return (n+1)**2
    
    return -1
    