from itertools import combinations
def solution(nums):
    cnt = 0
    for num in combinations(nums, 3):
        for i in range(2, sum(num)):
            if sum(num) % 2 == 0:
                break
            elif sum(num) % i == 0:
                break
        else:
            cnt += 1
    
    return cnt