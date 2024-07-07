def solution(babbling):
    answer = 0
    a = ['aya', 'ye', 'woo', 'ma']
    
    for b in babbling:
        for i in a:
            if i * 2 not in b:
                b = b.replace(i, ' ')
        
        if b.isspace():
            answer += 1
    return answer
    
    
    
    