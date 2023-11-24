def solution(s):
    
    s = s.lower()
    
    count1 = 0
    count2 = 0
    
    for i in s:
        if i == "p":
            count1 += 1
        elif i == "y":
            count2 += 1
    
    if count1 == count2:
        return True
    else:
        return False