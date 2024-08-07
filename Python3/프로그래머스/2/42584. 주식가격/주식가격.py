def solution(prices):
    array = []
    for i in range(len(prices)):
        cnt = 0
        for j in range(i+1, len(prices)):
            if prices[i] <= prices[j]:
                cnt += 1
            else:
                cnt += 1
                break
            
        array.append(cnt)
    
    return array