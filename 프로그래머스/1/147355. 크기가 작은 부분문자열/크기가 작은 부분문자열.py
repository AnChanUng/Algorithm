def solution(t, p):
    
    t = list(t)
    cnt = 0
    for i in range(len(t)-len(p)+1):
        if ''.join(t[i:i+len(p)]) <= p:
            cnt += 1

    return cnt