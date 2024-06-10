def solution(n):
    answer = 0
    array = []
    for i in range(2, n+1):
        for j in range(2, int(i**0.5)+1):
            if i == 2:
                array.append(i)
                answer += 1
                break
            elif i % j == 0:
                break
        else:
            array.append(i)
            answer += 1
    
    return answer