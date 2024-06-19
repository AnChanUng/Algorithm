def solution(elements):
    
    elements = elements * 2
    elements_len = len(elements)//2
    array = set()
    for i in range(1, elements_len+1):
        for j in range(elements_len):
            total = sum(elements[j:j+i])
            array.add(total)
    
    return len(array)