def solution(s):
    answer = []
    
    s = s[2:-2].split('},{')
    s = [w.split(',') for w in s]
    
    s.sort(key=lambda x: len(x))
    
    for i in range(len(s)):
        for j in range(len(s[i])):
            s[i][j] = int(s[i][j])
            if s[i][j] not in answer:
                answer.append(s[i][j])
    
    return answer