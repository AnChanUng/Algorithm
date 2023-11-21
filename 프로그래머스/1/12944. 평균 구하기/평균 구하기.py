def solution(arr):
    
    cnt = 0
    
    for i in range(len(arr)):
        cnt += arr[i]
    
    avg = cnt / len(arr)

    return avg