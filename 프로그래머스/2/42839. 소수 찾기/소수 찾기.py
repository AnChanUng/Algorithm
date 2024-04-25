from itertools import permutations

def is_prime(num):
    if num == 0 or num == 1:
        return False
    else:
        for i in range(2, (num//2)+1):
            if num % i == 0:
                return False
        return True

def solution(numbers):
    answer = 0
    pre_list = []
    num_list = list(map(int, numbers))
    print(num_list)
    
    for i in range(1, len(numbers)+1):
        for j in permutations(numbers, i):
            pre_list.append(''.join(j))
    pre_list = list(map(int, pre_list))
    pre_list = list(set(pre_list))
    
    for i in pre_list:
        if is_prime(i):
            answer += 1
    return answer