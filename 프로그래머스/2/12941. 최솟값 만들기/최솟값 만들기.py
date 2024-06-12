def solution(A,B):
    answer = 0

    #가장 작은수 x 가장큰수
    A.sort()
    B.sort(reverse=True)
    
    for i in range(len(A)):
        answer += A[i] * B[i]
    
    return answer