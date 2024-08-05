def solution(nums):
    
    count = {}
    for i in nums:
        if i in count:
            count[i] += 1
        else:
            count[i] = 1
    
    if len(count) >= len(nums) / 2:
        return len(nums) / 2
    else:
        return len(count)