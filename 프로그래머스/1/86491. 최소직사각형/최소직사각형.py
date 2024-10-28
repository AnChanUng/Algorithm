def solution(sizes):
    
    max_sizes = 0
    for i in range(len(sizes)):
        max_sizes = max(max(sizes[i]), max_sizes)
    
    min_sizes = 0
    for i in range(len(sizes)):
        min_sizes = max(min(sizes[i]), min_sizes) 
    
    answer = min_sizes * max_sizes
    
    return answer