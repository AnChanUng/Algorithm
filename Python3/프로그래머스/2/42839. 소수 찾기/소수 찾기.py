from itertools import permutations

def sosu(n):
    if n < 2:
        return False
    elif n == 2:
        return True
    
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    
    return True

def solution(numbers):
    cnt = 0
    arr = set()
    for i in range(1, len(numbers)+1):
        for j in permutations(numbers, i):
            result = ''.join(j)
            arr.add(int(result))
        
    for i in arr:
        if sosu(i):
            cnt += 1
    
    return cnt