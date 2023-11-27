def solution(arr):

    b = min(arr)
    arr.remove(b)
    
    if len(arr) < 2:
        return [-1]
    return arr